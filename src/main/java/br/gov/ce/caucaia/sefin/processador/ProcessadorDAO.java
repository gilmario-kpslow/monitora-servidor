package br.gov.ce.caucaia.sefin.processador;

import br.gov.ce.caucaia.sefin.infra.DAO;
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
public class ProcessadorDAO extends DAO<Processador, Long> implements Serializable {

    public List<Processador> listar() {
        CriteriaBuilder builder = getEm().getCriteriaBuilder();
        CriteriaQuery<Processador> query = builder.createQuery(Processador.class);
        Root<Processador> root = query.from(Processador.class);
        query.orderBy(builder.asc(root.get(Processador_.nome)));
        return getEm().createQuery(query).getResultList();
    }
}
