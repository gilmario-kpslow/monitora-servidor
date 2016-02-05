package br.gov.ce.caucaia.sefin.servico;

import br.gov.ce.caucaia.sefin.dao.ServicoDAO;
import br.gov.ce.caucaia.sefin.entidade.Servico;
import br.gov.ce.caucaia.sefin.entidade.Servidor;
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
public class ServicoServico implements ServicoInterface<Servico>, Serializable {

    @EJB
    private ServicoDAO dao;
    @EJB
    private EstatisticaServicoServico estatisticaServicoServico;

    @Override
    public void excluir(Servico t) {
        estatisticaServicoServico.excluirTodas(t);
        dao.excluir(t);
    }

    @Override
    public void atualizar(Servico t) {
        dao.atualizar(t);
    }

    @Override
    public void salvar(Servico t) {
        dao.salvar(t);
    }

    @Override
    public Servico carregar(Serializable pk) {
        return dao.carregar(Servico.class, pk);
    }

    public List<Servico> buscar(Servidor servidor) {
        return dao.buscar(servidor);
    }

    public List<Servico> buscarServicosTestaveis() {
        return dao.buscarServidorAtivo();
    }

    public void excluirTodos(Servidor t) {
        List<Servico> servicos = buscar(t);
        for (Servico s : servicos) {
            estatisticaServicoServico.excluirTodas(s);
        }
        dao.excluirTodos(t);
    }

    public List<Servico> buscarAtivos(Servidor s) {
        return dao.buscarServidorAtivo(s);
    }

}
