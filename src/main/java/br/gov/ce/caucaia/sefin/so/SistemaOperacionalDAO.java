package br.gov.ce.caucaia.sefin.so;

import br.gov.ce.caucaia.sefin.dao.DAO;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author gilmario
 */
@Stateless
public class SistemaOperacionalDAO extends DAO<SistemaOperacional, Long> implements Serializable {

    public List<SistemaOperacional> buscar() {
        CriteriaBuilder cb = getEm().getCriteriaBuilder();
        CriteriaQuery<SistemaOperacional> q = cb.createQuery(SistemaOperacional.class);
        Root<SistemaOperacional> root = q.from(SistemaOperacional.class);
        q.orderBy(cb.asc(root.get(SistemaOperacional_.nome)));
        return getEm().createQuery(q).getResultList();
    }

    public List<SistemaOperacional> buscar(Integer limit, Integer offset) {
        CriteriaBuilder cb = getEm().getCriteriaBuilder();
        CriteriaQuery<SistemaOperacional> q = cb.createQuery(SistemaOperacional.class);
        Root<SistemaOperacional> root = q.from(SistemaOperacional.class);
        q.orderBy(cb.asc(root.get(SistemaOperacional_.nome)));
        
        return getEm().createQuery(q).setMaxResults(limit).setFirstResult(offset).getResultList();
    }

}
