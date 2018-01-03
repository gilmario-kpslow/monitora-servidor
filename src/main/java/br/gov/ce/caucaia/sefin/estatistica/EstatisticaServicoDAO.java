package br.gov.ce.caucaia.sefin.estatistica;

import br.gov.ce.caucaia.sefin.dao.DAO;
import br.gov.ce.caucaia.sefin.servico.Servico;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author gilmario
 */
@Stateless
public class EstatisticaServicoDAO extends DAO<EstatisticaServico, Long> implements Serializable {

    public void excluirTodas(Servico s) {
        try {
            //getSession().createQuery("DELETE FROM EstatisticaServico e WHERE e.servico =:servico").setParameter(EstatisticaServico_.servico.getName(), s).executeUpdate();
            throw new Exception("Metodo não implementado");
        } catch (Exception ex) {
            Logger.getLogger(EstatisticaServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<EstatisticaServico> buscar(Servico s) {
        try {
            //return getSession().createCriteria(EstatisticaServico.class).add(Restrictions.eq(EstatisticaServico_.servico.getName(), s)).addOrder(Order.desc(EstatisticaServico_.dataHora.getName())).list();
            throw new Exception("Metodo não implementado");
        } catch (Exception ex) {
            Logger.getLogger(EstatisticaServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
