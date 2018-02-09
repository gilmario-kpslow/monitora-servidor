package br.gov.ce.caucaia.sefin.servico.testadores;

import br.gov.ce.caucaia.sefin.servico.Servico;
import br.gov.ce.caucaia.sefin.servico.StatusServico;
import br.gov.ce.caucaia.sefin.configuracao.ConfiguracaoServico;
import br.gov.ce.caucaia.sefin.servico.ServicoServico;
import br.gov.ce.caucaia.sefin.util.EnviaEmailUtil;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author gilmario
 */
@Stateless
public class TestadorServico implements Serializable {

    @EJB
    private Connector connector;
    @EJB
    private ServicoServico servicoServico;
    @EJB
    private ConfiguracaoServico configuracaoServico;
    private EnviaEmailUtil emailUtil;

    private static final Logger LOG = Logger.getLogger(TestadorServico.class.getName());

    public TestadorServico() {

    }

    public void testar(Servico servico) throws Exception {
        emailUtil = new EnviaEmailUtil();
        //servico.setUltimaResposta(Calendar.getInstance());
        if (servico.testar()) {
            if (!StatusServico.ATIVO.equals(servico.getStatusServico())) {
                servico.setStatusServico(StatusServico.ATIVO);
                servicoServico.atualizar(servico);
                servicoServico.notificarAtivacao(servico);
                connector.enviarMensagem("Servico " + servico.getNome() + " está ativo no servidor " + servico.getServidor().getNome());
                //emailUtil.enviar(configuracaoServico.getConfiguracao().getDestinatarios(), "Log dos servidores", "Servico " + servico.getNome() + " está ativo no servidor " + servico.getServidor().getNome());
                LOG.log(Level.INFO, "mensagem enviada");
            }
        } else if (!StatusServico.INATIVO.equals(servico.getStatusServico())) {
            servico.setStatusServico(StatusServico.INATIVO);
            servicoServico.atualizar(servico);
            servicoServico.notificarDesativacao(servico);
            connector.enviarMensagem("Servico " + servico.getNome() + " está inativo no servidor " + servico.getServidor().getNome());
            //emailUtil.enviar(configuracaoServico.getConfiguracao().getDestinatarios(), "Log dos servidores", "Servico " + servico.getNome() + " está inativo no servidor " + servico.getServidor().getNome());
            LOG.log(Level.INFO, "mensagem enviada");
        }
    }
}
