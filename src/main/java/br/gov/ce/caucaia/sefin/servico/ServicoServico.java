package br.gov.ce.caucaia.sefin.servico;

import br.gov.ce.caucaia.sefin.estatistica.EstatisticaServico;
import br.gov.ce.caucaia.sefin.estatistica.EstatisticaServicoDAO;
import br.gov.ce.caucaia.sefin.infra.ServicoInterface;
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
    private EstatisticaServicoDAO estatisticaDAO;

    @Override
    public void excluir(Serializable id) {
        Servico t = carregar(id);
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

    @Override
    public List<Servico> listar() {
        return dao.buscarServidorAtivo();
    }

    public void notificarAtivacao(Servico servico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void notificarDesativacao(Servico servico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<EstatisticaServico> buscar(Servico s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
