package br.gov.ce.caucaia.sefin.configuracao;

import br.gov.ce.caucaia.sefin.configuracao.ConfiguracaoDAO;
import br.gov.ce.caucaia.sefin.configuracao.Configuracao;
import br.gov.ce.caucaia.sefin.servico.ServicoInterface;
import java.io.Serializable;
import javax.annotation.PostConstruct;
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

    private Configuracao configuracao;
    @EJB
    private ConfiguracaoDAO dao;

    @PostConstruct
    public void inicializar() {
        criarConfiguracao();
    }

    private void criarConfiguracao() {
        configuracao = carregar(1L);
        if (configuracao == null) {
            configuracao = new Configuracao();
            configuracao.setId(1L);
            salvar(configuracao);
        }
    }

    @Override
    public void excluir(Configuracao t) {
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

    public Configuracao getConfiguracao() {
        return configuracao;
    }

}
