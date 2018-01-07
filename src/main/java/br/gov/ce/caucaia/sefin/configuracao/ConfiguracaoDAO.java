package br.gov.ce.caucaia.sefin.configuracao;

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
public class ConfiguracaoDAO extends DAO<Configuracao, Long> implements Serializable {

    public List<Configuracao> listar() {
        CriteriaBuilder cb = getEm().getCriteriaBuilder();
        CriteriaQuery<Configuracao> q = cb.createQuery(Configuracao.class);
        Root<Configuracao> root = q.from(Configuracao.class);
        q.orderBy(cb.asc(root.get(Configuracao_.email)));
        return getEm().createQuery(q).getResultList();
    }

}
