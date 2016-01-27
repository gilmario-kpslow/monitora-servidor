/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ce.caucaia.sefin.servico.testadores;

import br.gov.ce.caucaia.sefin.DashBoard;
import br.gov.ce.caucaia.sefin.entidade.Servico;
import br.gov.ce.caucaia.sefin.entidade.Servidor;
import br.gov.ce.caucaia.sefin.entidade.StatusServico;
import br.gov.ce.caucaia.sefin.entidade.StatusServidor;
import br.gov.ce.caucaia.sefin.servico.ServicoServico;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author gilmario
 */
@Stateless
public class TestadorServico implements Serializable {

    @Inject
    private DashBoard dashBoard;
    @EJB
    private Connector connector;
    @EJB
    private ServicoServico servicoServico;
    private static final Logger LOG = Logger.getLogger(TestadorServico.class.getName());

    public void testar(Servico servico) throws Exception {
        servico.setUltimaResposta(Calendar.getInstance());
        if (servico.testar()) {
            if (!StatusServico.Ativo.equals(servico.getStatusServico())) {
                servico.setStatusServico(StatusServico.Ativo);
                dashBoard.atualizar();
                connector.enviarMensagem("Servico " + servico.getNome() + " ativo" + " no servidor " + servico.getServidor().getNome());
                LOG.log(Level.INFO, "mensagem enviada");
            }
        } else if (!StatusServico.Inativo.equals(servico.getStatusServico())) {
            servico.setStatusServico(StatusServico.Inativo);
            dashBoard.atualizar();
            connector.enviarMensagem("Servico " + servico.getNome() + " inativo" + " no servidor " + servico.getServidor().getNome());
            LOG.log(Level.INFO, "mensagem enviada");
        }
        servicoServico.atualizar(servico);
    }
}
