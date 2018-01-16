package br.gov.ce.caucaia.sefin.servidor;

import br.gov.ce.caucaia.sefin.estatistica.EstatisticaServidorDAO;
import br.gov.ce.caucaia.sefin.infra.ServicoInterface;
import br.gov.ce.caucaia.sefin.servico.ServicoServico;
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
    @EJB
    private EstatisticaServidorDAO estatisticaDAO;
    @EJB
    private ServicoServico servicoServico;

    @Override
    public void excluir(Serializable id) {
        Servidor t = carregar(id);
        dao.excluir(t);
    }

    public void excluir(Long id) {
        Servidor servidor = carregar(id);
        excluir(servidor);
    }

    @Override
    public void atualizar(Servidor t) {
        dao.atualizar(t);
    }

    @Override
    public void salvar(Servidor t) {
        dao.salvar(t);
    }

    @Override
    public Servidor carregar(Serializable pk) {
        return dao.carregar(Servidor.class, pk);
    }

    public Object buscar(Integer limit, Integer offset) {
        return dao.buscar(limit, offset);
    }

    @Override
    public List<Servidor> listar() {
        return dao.buscar();
    }

    void notificarAtivacao(Servidor servidor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void notificarDesativacao(Servidor servidor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
