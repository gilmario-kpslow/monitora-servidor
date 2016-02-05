package br.gov.ce.caucaia.sefin;

import br.gov.ce.caucaia.sefin.entidade.Servico;
import br.gov.ce.caucaia.sefin.entidade.TipoServico;
import br.gov.ce.caucaia.sefin.servico.ServicoServico;
import br.gov.ce.caucaia.sefin.util.MensagemUtil;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author gilmario
 */
@Named
@ViewScoped
public class CadastraServicoBean implements Serializable {

    @EJB
    private ServicoServico servicoServico;
    @Inject
    private DashBoard board;
    private static final Logger LOG = Logger.getLogger(CadastraServicoBean.class.getName());

    private Servico servico;

    @PostConstruct
    private void init() {
        servico = new Servico();
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public void salvar() {
        try {
            servico.setServidor(board.getSelecionado());
            servicoServico.salvar(servico);
            board.atualizar();
            board.dashboard();
            init();
            MensagemUtil.mensagem("servico registrado");
        } catch (Exception e) {
            MensagemUtil.mensagem("Erro", e.getMessage(), FacesMessage.SEVERITY_ERROR);
            LOG.log(Level.SEVERE, "Erro", e);
        }
    }

    public void excluir(Servico servico) {
        try {
            servicoServico.excluir(servico);
            board.mostraServicos(servico.getServidor());
            board.atualizar();
            MensagemUtil.mensagem("servico excluido");
        } catch (Exception e) {
            LOG.log(Level.SEVERE, "Erro", e);
            MensagemUtil.mensagem("Erro", e.getMessage(), FacesMessage.SEVERITY_ERROR);

        }
    }

    public List<TipoServico> getTiposServico() {
        return Arrays.asList(TipoServico.values());
    }

}
