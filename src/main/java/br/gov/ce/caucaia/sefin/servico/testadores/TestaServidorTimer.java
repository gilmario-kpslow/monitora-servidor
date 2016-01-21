package br.gov.ce.caucaia.sefin.servico.testadores;

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

/**
 *
 * @author gilmario
 */
@Singleton
@Startup
public class TestaServidorTimer implements Serializable {

    @EJB
    private ServidorServico servico;
    private static final Logger LOG = Logger.getLogger(TestaServidorTimer.class.getName());

    @Schedule(hour = "*", minute = "*", second = "*/15")
    public void testarServidores() {
        List<Servidor> listaDeServidores = servico.buscar();
        for (Servidor s : listaDeServidores) {
            try {
                s.testar();
                servico.atualizar(s);
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "Erro", e);
            }
        }
    }

}
