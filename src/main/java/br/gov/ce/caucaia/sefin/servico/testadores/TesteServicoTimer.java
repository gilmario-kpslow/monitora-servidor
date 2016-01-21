package br.gov.ce.caucaia.sefin.servico.testadores;

import br.gov.ce.caucaia.sefin.entidade.Servico;
import br.gov.ce.caucaia.sefin.servico.ServicoServico;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
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
public class TesteServicoTimer implements Serializable {

    @EJB
    private ServicoServico servico;
    private static final Logger LOG = Logger.getLogger(TesteServicoTimer.class.getName());

    @Schedule(hour = "*", minute = "*", second = "*/30")
    public void testaServicos() {
        List<Servico> servicos = servico.buscarServicosTestaveis();
        for (Servico s : servicos) {
            try {
                s.testar();
                servico.atualizar(s);
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "Erro", e);
            }
        }
    }
}
