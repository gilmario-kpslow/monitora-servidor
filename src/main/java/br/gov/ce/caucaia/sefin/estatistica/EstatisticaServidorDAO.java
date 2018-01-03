package br.gov.ce.caucaia.sefin.estatistica;

import br.gov.ce.caucaia.sefin.dao.DAO;
import br.gov.ce.caucaia.sefin.servidor.Servidor;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author gilmario
 */
@Stateless
public class EstatisticaServidorDAO extends DAO<EstatisticaServidor, Long> implements Serializable {

    public void excluirTodas(Servidor t) {

        try {
            //getSession().createQuery("DELETE FROM EstatisticaServidor e WHERE e.servidor =:servidor").setParameter(EstatisticaServidor_.servidor.getName(), t).executeUpdate();
            throw new Exception("Metodo não implementado");
        } catch (Exception ex) {
            Logger.getLogger(EstatisticaServidorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<EstatisticaServidor> buscar(Servidor servidor) {
        try {
            //return getSession().createCriteria(EstatisticaServidor.class).add(Restrictions.eq(EstatisticaServidor_.servidor.getName(), servidor)).addOrder(Order.desc(EstatisticaServidor_.dataHora.getName())).list();
            throw new Exception("Metodo não implementado");
        } catch (Exception ex) {
            Logger.getLogger(EstatisticaServidorDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
