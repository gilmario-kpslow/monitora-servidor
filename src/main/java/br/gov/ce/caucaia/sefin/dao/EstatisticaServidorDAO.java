package br.gov.ce.caucaia.sefin.dao;

import br.gov.ce.caucaia.sefin.entidade.EstatisticaServidor;
import br.gov.ce.caucaia.sefin.entidade.EstatisticaServidor_;
import br.gov.ce.caucaia.sefin.entidade.Servidor;
import java.io.Serializable;
import java.util.List;
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
        getSession().createQuery("DELETE FROM EstatisticaServidor e WHERE e.servidor =:servidor").setParameter(EstatisticaServidor_.servidor.getName(), t).executeUpdate();
    }

    public List<EstatisticaServidor> buscar(Servidor servidor) {
        return getSession().createCriteria(EstatisticaServidor.class).add(Restrictions.eq(EstatisticaServidor_.servidor.getName(), servidor)).addOrder(Order.desc(EstatisticaServidor_.dataHora.getName())).list();
    }

}
