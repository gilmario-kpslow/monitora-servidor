package br.gov.ce.caucaia.sefin.servico.testadores;

import br.gov.ce.caucaia.sefin.DashBoard;
import br.gov.ce.caucaia.sefin.entidade.Servico;
import br.gov.ce.caucaia.sefin.entidade.StatusServico;
import br.gov.ce.caucaia.sefin.servico.EstatisticaServicoServico;
import br.gov.ce.caucaia.sefin.servico.ServicoServico;
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
    @EJB
    private EstatisticaServicoServico ess;
    private static final Logger LOG = Logger.getLogger(TestadorServico.class.getName());

    public void testar(Servico servico) throws Exception {
        servico.setUltimaResposta(Calendar.getInstance());
        if (servico.testar()) {
            if (!StatusServico.Ativo.equals(servico.getStatusServico())) {
                servico.setStatusServico(StatusServico.Ativo);
                dashBoard.atualizar();
                ess.notificarAtivacao(servico);
                connector.enviarMensagem("Servico " + servico.getNome() + " ativo" + " no servidor " + servico.getServidor().getNome());
                LOG.log(Level.INFO, "mensagem enviada");
            }
        } else if (!StatusServico.Inativo.equals(servico.getStatusServico())) {
            servico.setStatusServico(StatusServico.Inativo);
            dashBoard.atualizar();
            ess.notificarDesativacao(servico);
            connector.enviarMensagem("Servico " + servico.getNome() + " inativo" + " no servidor " + servico.getServidor().getNome());
            LOG.log(Level.INFO, "mensagem enviada");
        }
        servicoServico.atualizar(servico);
    }
}
