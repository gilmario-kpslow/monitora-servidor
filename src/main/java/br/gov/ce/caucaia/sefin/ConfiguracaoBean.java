package br.gov.ce.caucaia.sefin;

import br.gov.ce.caucaia.sefin.entidade.Configuracao;
import br.gov.ce.caucaia.sefin.servico.ConfiguracaoServico;
import br.gov.ce.caucaia.sefin.util.MensagemUtil;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author gilmario
 */
@Named
@ViewScoped
public class ConfiguracaoBean implements Serializable {

    @EJB
    private ConfiguracaoServico servico;
    private Configuracao configuracao;

    @PostConstruct
    private void iniciar() {
        configuracao = servico.getConfiguracao();
    }

    public void salvar() {
        try {
            servico.atualizar(configuracao);
            MensagemUtil.mensagem("servidor registrado");
        } catch (Exception e) {
            MensagemUtil.mensagem("Erro", e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public Configuracao getConfiguracao() {
        return configuracao;
    }

    public void setConfiguracao(Configuracao configuracao) {
        this.configuracao = configuracao;
    }

}
