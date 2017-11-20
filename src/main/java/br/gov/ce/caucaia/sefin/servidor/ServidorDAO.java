package br.gov.ce.caucaia.sefin.servidor;

import br.gov.ce.caucaia.sefin.dao.DAO;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

/**
 *
 * @author gilmario
 */
@Stateless
public class ServidorDAO extends DAO<Servidor, Long> implements Serializable {

    public List<Servidor> buscar() {
        return getSession().createCriteria(Servidor.class).addOrder(Order.asc(Servidor_.ip.getName())).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

}
