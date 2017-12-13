package br.gov.ce.caucaia.sefin.servidor;

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
public class ServidorDAO extends DAO<Servidor, Long> implements Serializable {

    public List<Servidor> buscar() {
        CriteriaBuilder cb = getEm().getCriteriaBuilder();
        CriteriaQuery<Servidor> q = cb.createQuery(Servidor.class);
        Root<Servidor> root = q.from(Servidor.class);
        q.orderBy(cb.asc(root.get(Servidor_.nome)));
        return getEm().createQuery(q).getResultList();
    }

    public List<Servidor> buscar(Integer limit, Integer offset) {
        CriteriaBuilder cb = getEm().getCriteriaBuilder();
        CriteriaQuery<Servidor> q = cb.createQuery(Servidor.class);
        Root<Servidor> root = q.from(Servidor.class);
        q.orderBy(cb.asc(root.get(Servidor_.nome)));
        
        return getEm().createQuery(q).setMaxResults(limit).setFirstResult(offset).getResultList();
    }

}
