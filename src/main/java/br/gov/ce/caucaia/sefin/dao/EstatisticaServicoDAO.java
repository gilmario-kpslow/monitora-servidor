package br.gov.ce.caucaia.sefin.dao;

import br.gov.ce.caucaia.sefin.entidade.EstatisticaServico;
import br.gov.ce.caucaia.sefin.entidade.EstatisticaServico_;
import br.gov.ce.caucaia.sefin.entidade.Servico;
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
public class EstatisticaServicoDAO extends DAO<EstatisticaServico, Long> implements Serializable {

    public void excluirTodas(Servico s) {
        getSession().createQuery("DELETE FROM EstatisticaServico e WHERE e.servico =:servico").setParameter(EstatisticaServico_.servico.getName(), s).executeUpdate();
    }

    public List<EstatisticaServico> buscar(Servico s) {
        return getSession().createCriteria(EstatisticaServico.class).add(Restrictions.eq(EstatisticaServico_.servico.getName(), s)).addOrder(Order.desc(EstatisticaServico_.dataHora.getName())).list();
    }

}
