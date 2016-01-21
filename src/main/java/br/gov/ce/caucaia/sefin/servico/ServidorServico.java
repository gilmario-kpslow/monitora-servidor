package br.gov.ce.caucaia.sefin.servico;

import br.gov.ce.caucaia.sefin.entidade.Servidor;
import br.gov.ce.caucaia.sefin.dao.ServidorDAO;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 * @author gilmario
 */
@Stateless
@LocalBean
public class ServidorServico implements ServicoInterface<Servidor>, Serializable {

    @EJB
    private ServidorDAO dao;

    @Override
    public void excluir(Servidor t) {
        dao.excluir(t);
    }

    @Override
    public void atualizar(Servidor t) {
        dao.atualizar(t);
    }

    @Override
    public void salvar(Servidor t) {
        dao.salvar(t);
    }

    public List<Servidor> buscar() {
        return dao.buscar();
    }

    @Override
    public Servidor carregar(Serializable pk) {
        return dao.carregar(Servidor.class, pk);
    }

}
