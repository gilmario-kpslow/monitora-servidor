package br.gov.ce.caucaia.sefin.infra;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

/**
 *
 * @author gilmario
 * @param <T>
 */
public class Repositorio<T> {

    private final EntityManager em;
    private final CriteriaBuilder builder;
    private final Class<T> entidade;

    public Repositorio(EntityManager em, Class<T> entidade) {
        this.em = em;
        this.builder = em.getCriteriaBuilder();
        this.entidade = entidade;
    }

    public <Y extends Object> List<T> listarPor(SingularAttribute attribute, Y valor) {
        CriteriaQuery<T> query = builder.createQuery(entidade);
        Root<T> root = query.from(entidade);
        query.where(builder.equal(root.get(attribute), valor));
        return em.createQuery(query).getResultList();
    }

}
