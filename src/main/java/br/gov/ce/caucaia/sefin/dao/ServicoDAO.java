package br.gov.ce.caucaia.sefin.dao;

import br.gov.ce.caucaia.sefin.entidade.Servico;
import br.gov.ce.caucaia.sefin.entidade.Servidor;
import br.gov.ce.caucaia.sefin.entidade.StatusServidor;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author gilmario
 */
@Stateless
public class ServicoDAO extends DAO<Servico, Long> implements Serializable {

    public List<Servico> buscar(Servidor servidor) {
        return getSession().createCriteria(Servico.class).add(Restrictions.eq("servidor", servidor)).list();
    }

    public List<Servico> buscarServidorAtivo() {
        return getSession().createQuery("SELECT s FROM Servico s WHERE s.servidor.status =:ativo ").setParameter("ativo", StatusServidor.Ativo).list();
    }
}
