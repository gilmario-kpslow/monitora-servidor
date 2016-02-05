package br.gov.ce.caucaia.sefin.dao;

import br.gov.ce.caucaia.sefin.entidade.EstatisticaServico;
import br.gov.ce.caucaia.sefin.entidade.EstatisticaServico_;
import br.gov.ce.caucaia.sefin.entidade.Servico;
import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author gilmario
 */
@Stateless
public class EstatisticaServicoDAO extends DAO<EstatisticaServico, Long> implements Serializable {

    public void excluirTodas(Servico s) {
        getSession().createQuery("DELETE FROM EstatisticaServico e WHERE e.servico =:servico").setParameter(EstatisticaServico_.servico.getName(), s).executeUpdate();
    }

}
