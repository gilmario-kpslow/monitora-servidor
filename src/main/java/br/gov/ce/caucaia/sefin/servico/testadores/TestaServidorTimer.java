package br.gov.ce.caucaia.sefin.servico.testadores;

import br.gov.ce.caucaia.sefin.servidor.TestadorServidor;
import br.gov.ce.caucaia.sefin.servidor.Servidor;
import br.gov.ce.caucaia.sefin.servidor.ServidorServico;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.mail.MessagingException;

/**
 *
 * @author gilmario
 */
@Singleton
@Startup
public class TestaServidorTimer implements Serializable {

    @EJB
    private ServidorServico servico;
    @EJB
    private TestadorServidor testadorServidor;
    private static final Logger LOG = Logger.getLogger(TestaServidorTimer.class.getName());

    //@Schedule(hour = "*", minute = "*", second = "0")
    public void testarServidores() {
        List<Servidor> listaDeServidores = servico.listar();
        listaDeServidores.forEach((s) -> {
            try {
                testadorServidor.testar(s);
            } catch (IOException | InterruptedException | MessagingException e) {
                LOG.log(Level.SEVERE, "Erro", e);
            }
        });
    }

}
