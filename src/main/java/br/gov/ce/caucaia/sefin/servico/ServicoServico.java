package br.gov.ce.caucaia.sefin.servico;

import br.gov.ce.caucaia.sefin.configuracao.EstatisticaServicoServico;
import br.gov.ce.caucaia.sefin.servidor.Servidor;
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

    public List<Servico> buscar(Long idServidor) {
        Servidor servidor = new Servidor();
        servidor.setId(idServidor);
        return dao.buscar(servidor);
    }

    public void excluir(Long id) {
        Servico servico = dao.carregar(Servico.class, id);
        dao.excluir(servico);
    }

}
