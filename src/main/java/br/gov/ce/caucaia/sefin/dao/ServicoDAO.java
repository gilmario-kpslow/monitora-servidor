package br.gov.ce.caucaia.sefin.dao;

import br.gov.ce.caucaia.sefin.entidade.Servico;
import br.gov.ce.caucaia.sefin.entidade.Servico_;
import br.gov.ce.caucaia.sefin.entidade.Servidor;
import br.gov.ce.caucaia.sefin.entidade.StatusServico;
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
public class ServicoDAO extends DAO<Servico, Long> implements Serializable {

    public List<Servico> buscar(Servidor servidor) {
        return getSession().createCriteria(Servico.class).add(Restrictions.eq(Servico_.servidor.getName(), servidor)).list();
    }

    public List<Servico> buscarServidorAtivo() {
        return getSession().createCriteria(Servico.class).add(Restrictions.eq(Servico_.statusServico.getName(), StatusServico.Ativo)).addOrder(Order.asc(Servico_.nome.getName())).list();
    }
}
