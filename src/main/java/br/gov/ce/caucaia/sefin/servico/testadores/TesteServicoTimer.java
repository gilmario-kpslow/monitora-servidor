package br.gov.ce.caucaia.sefin.servico.testadores;

import br.gov.ce.caucaia.sefin.DashBoard;
import br.gov.ce.caucaia.sefin.servico.Servico;
import br.gov.ce.caucaia.sefin.servico.ServicoServico;
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
public class TesteServicoTimer implements Serializable {

    @EJB
    private ServicoServico servico;
    @EJB
    private TestadorServico testadorServico;
    @Inject
    private DashBoard dashBoard;
    private static final Logger LOG = Logger.getLogger(TesteServicoTimer.class.getName());

    //@Schedule(hour = "*", minute = "*", second = "30")
    public void testaServicos() {
        List<Servico> servicos = servico.buscarServicosTestaveis();
        for (Servico s : servicos) {
            try {
                testadorServico.testar(s);
            } catch (Exception e) {
                LOG.log(Level.SEVERE, "Erro", e);
            }
        }
        dashBoard.atualizar();
    }
}
