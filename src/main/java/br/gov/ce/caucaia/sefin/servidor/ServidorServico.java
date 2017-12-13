package br.gov.ce.caucaia.sefin.servidor;

import br.gov.ce.caucaia.sefin.configuracao.EstatisticaServidorServico;
import br.gov.ce.caucaia.sefin.servico.ServicoInterface;
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
    private EstatisticaServidorServico estatisticaServidorServico;
    @EJB
    private ServicoServico servicoServico;

    @Override
    public void excluir(Servidor t) {
        servicoServico.excluirTodos(t);
        estatisticaServidorServico.excluirTodas(t);
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

    public List<Servidor> buscar() {
        return dao.buscar();
    }

    @Override
    public Servidor carregar(Serializable pk) {
        return dao.carregar(Servidor.class, pk);
    }

    public Object buscar(Integer limit, Integer offset) {
        return dao.buscar(limit, offset);
    }

}
