package br.gov.ce.caucaia.sefin.dao;

import br.gov.ce.caucaia.sefin.entidade.EstatisticaServidor;
import br.gov.ce.caucaia.sefin.entidade.EstatisticaServidor_;
import br.gov.ce.caucaia.sefin.entidade.Servidor;
import java.io.Serializable;
import javax.ejb.Stateless;

/**
 *
 * @author gilmario
 */
@Stateless
public class EstatisticaServidorDAO extends DAO<EstatisticaServidor, Long> implements Serializable {

    public void excluirTodas(Servidor t) {
        getSession().createQuery("DELETE FROM EstatisticaServidor e WHERE e.servidor =:servidor").setParameter(EstatisticaServidor_.servidor.getName(), t).executeUpdate();
    }

}
