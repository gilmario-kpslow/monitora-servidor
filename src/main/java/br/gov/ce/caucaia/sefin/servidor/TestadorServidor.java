package br.gov.ce.caucaia.sefin.servidor;

import br.gov.ce.caucaia.sefin.util.TestadorDePing;
import br.gov.ce.caucaia.sefin.configuracao.ConfiguracaoServico;
import br.gov.ce.caucaia.sefin.servico.testadores.Connector;
import br.gov.ce.caucaia.sefin.util.EnviaEmailUtil;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.mail.MessagingException;

/**
 *
 * @author gilmario
 */
@Stateless
public class TestadorServidor implements Serializable {

    private final TestadorDePing ping;
    @EJB
    private ServidorServico servico;
    @EJB
    private Connector connector;
    private static final Logger LOG = Logger.getLogger(TestadorServidor.class.getName());
    private EnviaEmailUtil emailUtil;
    @EJB
    private ConfiguracaoServico configuracaoServico;

    public TestadorServidor() {
        ping = new TestadorDePing();
    }

    public void testar(Servidor servidor) throws IOException, MessagingException, InterruptedException {
        emailUtil = new EnviaEmailUtil();
        servidor.setUltimoTeste(LocalDate.now());
        if (ping.testaPing(servidor.getIp())) {
            if (!StatusServidor.Ativo.equals(servidor.getStatus())) {
                servidor.setStatus(StatusServidor.Ativo);
                servico.atualizar(servidor);
                servico.notificarAtivacao(servidor);
                connector.enviarMensagem("Servidor " + servidor.getNome() + " está ativo");
                //emailUtil.enviar(configuracaoServico.getConfiguracao().getDestinatarios(), "Log dos servidores", "Servidor " + servidor.getNome() + " está ativo");
                LOG.log(Level.INFO, "mensagem enviada");
            }
        } else if (!StatusServidor.Inativo.equals(servidor.getStatus())) {
            servidor.setStatus(StatusServidor.Inativo);
            servico.atualizar(servidor);
            servico.notificarDesativacao(servidor);
            connector.enviarMensagem("Servidor " + servidor.getNome() + " offline");
            //emailUtil.enviar(configuracaoServico.getConfiguracao().getDestinatarios(), "Log dos servidores", "Servidor " + servidor.getNome() + " está inativo");
            LOG.log(Level.INFO, "mensagem enviada");
        }
    }

}
