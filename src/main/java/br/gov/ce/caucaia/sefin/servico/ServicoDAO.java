package br.gov.ce.caucaia.sefin.servico;

import br.gov.ce.caucaia.sefin.infra.DAO;
import br.gov.ce.caucaia.sefin.servidor.Servidor;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author gilmario
 */
@Stateless
public class ServicoDAO extends DAO<Servico, Long> implements Serializable {

    public List<Servico> buscar(Servidor servidor) {
        try {
            //return getSession().createCriteria(Servico.class).add(Restrictions.eq(Servico_.servidor.getName(), servidor)).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
            throw new Exception("Metodo não implementado");
        } catch (Exception ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public List<Servico> buscarServidorAtivo() {
        try {
            //Criteria c = getSession().createCriteria(Servico.class).addOrder(Order.asc(Servico_.nome.getName())).createCriteria(Servico_.servidor.getName(), JoinType.INNER_JOIN).add(Restrictions.eq(Servidor_.status.getName(), StatusServidor.Ativo));
            //return c.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
            throw new Exception("Metodo não implementado");
        } catch (Exception ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void excluirTodos(Servidor t) {
        try {
            //getSession().createQuery(" DELETE FROM Servico s WHERE s.servidor =:servidor").setParameter(Servico_.servidor.getName(), t).executeUpdate();
            throw new Exception("Metodo não implementado");
        } catch (Exception ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Servico> buscarServidorAtivo(Servidor s) {
        try {
            //return getSession().createCriteria(Servico.class).add(Restrictions.eq(Servico_.servidor.getName(), s)).add(Restrictions.eq(Servico_.statusServico.getName(), StatusServico.Ativo)).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
            throw new Exception("Metodo não implementado");
        } catch (Exception ex) {
            Logger.getLogger(ServicoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
