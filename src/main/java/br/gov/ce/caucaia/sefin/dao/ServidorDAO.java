package br.gov.ce.caucaia.sefin.dao;

import br.gov.ce.caucaia.sefin.entidade.Servidor;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author gilmario
 */
@Stateless
public class ServidorDAO extends DAO<Servidor, String> implements Serializable {

    public List<Servidor> buscar() {
        return getSession().createQuery("SELECT s FROM Servidor s").list();
    }

}
