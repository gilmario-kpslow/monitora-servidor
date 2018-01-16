package br.gov.ce.caucaia.sefin.estatistica;

import br.gov.ce.caucaia.sefin.infra.DAO;
import br.gov.ce.caucaia.sefin.infra.Repositorio;
import br.gov.ce.caucaia.sefin.servico.Servico;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

/**
 *
 * @author gilmario
 */
@Stateless
public class EstatisticaServicoDAO extends DAO<EstatisticaServico, Long> implements Serializable {

    private Repositorio<EstatisticaServico> repositorio;

    @PostConstruct
    private void init() {
        repositorio = new Repositorio<>(getEm(), EstatisticaServico.class);
    }

    public List<EstatisticaServico> buscar(Servico servico) {
        try {
            return repositorio.listarPor(EstatisticaServico_.servico, servico);
        } catch (Exception ex) {
            Logger.getLogger(EstatisticaServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
