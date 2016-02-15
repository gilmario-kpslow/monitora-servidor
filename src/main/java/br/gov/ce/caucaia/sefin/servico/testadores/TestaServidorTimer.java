package br.gov.ce.caucaia.sefin.servico.testadores;

import br.gov.ce.caucaia.sefin.DashBoard;
import br.gov.ce.caucaia.sefin.entidade.Servidor;
import br.gov.ce.caucaia.sefin.servico.ServidorServico;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

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
    @Inject
    private DashBoard dashBoard;
    private static final Logger LOG = Logger.getLogger(TestaServidorTimer.class.getName());

    @Schedule(hour = "*", minute = "*", second = "0")
    public void testarServidores() {
        List<Servidor> listaDeServidores = servico.buscar();
        for (Servidor s : listaDeServidores) {
            try {
                testadorServidor.testar(s);
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "Erro", e);
            }
        }
        dashBoard.atualizar();
    }

}
