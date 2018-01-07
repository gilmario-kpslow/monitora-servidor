package br.gov.ce.caucaia.sefin.configuracao;

import br.gov.ce.caucaia.sefin.infra.ServicoInterface;
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
public class ConfiguracaoServico implements ServicoInterface<Configuracao>, Serializable {

    @EJB
    private ConfiguracaoDAO dao;

    @Override
    public void excluir(Serializable id) {
        Configuracao t = carregar(id);
        dao.excluir(t);
    }

    @Override
    public void atualizar(Configuracao t) {
        dao.atualizar(t);
    }

    @Override
    public void salvar(Configuracao t) {
        dao.salvar(t);
    }

    @Override
    public Configuracao carregar(Serializable pk) {
        return dao.carregar(Configuracao.class, pk);
    }

    @Override
    public List<Configuracao> listar() {
        return dao.listar();
    }

}
