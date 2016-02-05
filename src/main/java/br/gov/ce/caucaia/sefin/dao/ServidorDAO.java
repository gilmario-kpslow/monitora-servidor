package br.gov.ce.caucaia.sefin.dao;

import br.gov.ce.caucaia.sefin.entidade.Servidor;
import br.gov.ce.caucaia.sefin.entidade.Servidor_;
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
