package br.gov.ce.caucaia.sefin.servico;

import br.gov.ce.caucaia.sefin.infra.DAO;
import br.gov.ce.caucaia.sefin.servidor.Servidor;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author gilmario
 */
@Stateless
public class ServicoDAO extends DAO<Servico, Long> implements Serializable {

    public List<Servico> buscar(Servidor servidor) {
        try {
            CriteriaBuilder builder = getEm().getCriteriaBuilder();
            CriteriaQuery<Servico> query = builder.createQuery(Servico.class);
            Root<Servico> root = query.from(Servico.class);
            query.where(builder.equal(root.get(Servico_.servidor), servidor));
            query.orderBy(builder.asc(root.get(Servico_.nome)));
            return getEm().createQuery(query).getResultList();
        } catch (Exception ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Servico> buscarServidorAtivo() {
        try {
            CriteriaBuilder builder = getEm().getCriteriaBuilder();
            CriteriaQuery<Servico> query = builder.createQuery(Servico.class);
            Root<Servico> root = query.from(Servico.class);
            query.where(builder.equal(root.get(Servico_.statusServico), StatusServico.ATIVO));
            query.orderBy(builder.asc(root.get(Servico_.nome)));
            return getEm().createQuery(query).getResultList();
        } catch (Exception ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void excluirTodos(Servidor servidor) {
        try {
            CriteriaBuilder builder = getEm().getCriteriaBuilder();
            CriteriaDelete<Servico> query = builder.createCriteriaDelete(Servico.class);
            Root<Servico> root = query.from(Servico.class);
            query.where(builder.equal(root.get(Servico_.servidor), servidor));
            getEm().createQuery(query).executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Servico> buscarServidorAtivo(Servidor servidor) {
        try {
            CriteriaBuilder builder = getEm().getCriteriaBuilder();
            CriteriaQuery<Servico> query = builder.createQuery(Servico.class);
            Root<Servico> root = query.from(Servico.class);
            query.where(
                    builder.equal(root.get(Servico_.servidor), servidor),
                    builder.equal(root.get(Servico_.statusServico), StatusServico.ATIVO)
            );
            query.orderBy(builder.asc(root.get(Servico_.nome)));
            return getEm().createQuery(query).getResultList();
        } catch (Exception ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
