/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.ce.caucaia.sefin;

import br.gov.ce.caucaia.sefin.entidade.Servico;
import br.gov.ce.caucaia.sefin.entidade.TipoServico;
import br.gov.ce.caucaia.sefin.servico.ServicoServico;
import br.gov.ce.caucaia.sefin.util.MensagemUtil;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
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
            board.getSelecionado().addServico(servico);
            board.atualizar();
            init();
            MensagemUtil.mensagem("servico registrado");
            board.dashboard();
        } catch (Exception e) {
            MensagemUtil.mensagem("Erro", e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public void excluir(Servico servico) {
        try {
            board.mostraServicos(servico.getServidor());
            servicoServico.excluir(servico);
            board.atualizar();
            MensagemUtil.mensagem("servico excluido");
        } catch (Exception e) {
            MensagemUtil.mensagem("Erro", e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public List<TipoServico> getTiposServico() {
        return Arrays.asList(TipoServico.values());
    }

}
