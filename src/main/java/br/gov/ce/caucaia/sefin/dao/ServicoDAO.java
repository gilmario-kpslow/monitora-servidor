package br.gov.ce.caucaia.sefin.dao;

import br.gov.ce.caucaia.sefin.entidade.Servico;
import br.gov.ce.caucaia.sefin.entidade.Servico_;
import br.gov.ce.caucaia.sefin.entidade.Servidor;
import br.gov.ce.caucaia.sefin.entidade.Servidor_;
import br.gov.ce.caucaia.sefin.entidade.StatusServico;
import br.gov.ce.caucaia.sefin.entidade.StatusServidor;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

/**
 *
 * @author gilmario
 */
@Stateless
public class ServicoDAO extends DAO<Servico, Long> implements Serializable {

    public List<Servico> buscar(Servidor servidor) {
        return getSession().createCriteria(Servico.class).add(Restrictions.eq(Servico_.servidor.getName(), servidor)).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    public List<Servico> buscarServidorAtivo() {
        Criteria c = getSession().createCriteria(Servico.class).addOrder(Order.asc(Servico_.nome.getName())).createCriteria(Servico_.servidor.getName(), JoinType.INNER_JOIN).add(Restrictions.eq(Servidor_.status.getName(), StatusServidor.Ativo));
        return c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }

    public void excluirTodos(Servidor t) {
        getSession().createQuery(" DELETE FROM Servico s WHERE s.servidor =:servidor").setParameter(Servico_.servidor.getName(), t).executeUpdate();
    }

    public List<Servico> buscarServidorAtivo(Servidor s) {
        return getSession().createCriteria(Servico.class).add(Restrictions.eq(Servico_.servidor.getName(), s)).add(Restrictions.eq(Servico_.statusServico.getName(), StatusServico.Ativo)).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
    }
}
