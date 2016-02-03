package br.gov.ce.caucaia.sefin;

import br.gov.ce.caucaia.sefin.entidade.Servico;
import br.gov.ce.caucaia.sefin.entidade.Servidor;
import br.gov.ce.caucaia.sefin.servico.ServicoServico;
import br.gov.ce.caucaia.sefin.servico.ServidorServico;
import br.gov.ce.caucaia.sefin.util.MensagemUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author gilmario
 */
@Named
@ApplicationScoped
public class DashBoard implements Serializable {

    private List<Servidor> listaDeServidores;
    @EJB
    private ServidorServico servico;
    @EJB
    private ServicoServico servicoServico;
    private String pagina;
    private Servidor selecionado;

    @PostConstruct
    private void init() {
        pagina = "board";
        listaDeServidores = new ArrayList<>(servico.buscar());
    }

    public void atualizar() {
        init();
    }

    public List<Servidor> getListaDeServidores() {
        return listaDeServidores;
    }

    public void setListaDeServidores(List<Servidor> listaDeServidores) {
        this.listaDeServidores = listaDeServidores;
    }

    public String getPagina() {
        return pagina;
    }

    public void cadastroServico() {
        pagina = "novo_servico";
    }

    public void cadastroServidor() {
        pagina = "novo_servidor";
    }

    public void dashboard() {
        pagina = "board";
    }

    public Servidor getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(Servidor selecionado) {
        this.selecionado = selecionado;
    }

    public void mostraServicos(Servidor servidor) {
        this.selecionado = servidor;
        pagina = "servicos";
    }

    public void testarServidor(Servidor servidor) {
        try {
            servidor.testar();
            servico.atualizar(servidor);
            MensagemUtil.mensagem("Servidor testado com sucesso");
        } catch (Exception e) {
            MensagemUtil.mensagem(e.getMessage());
        }
    }

    public void testarServico(Servico s) {
        try {
            s.testar();
            servicoServico.atualizar(s);
            MensagemUtil.mensagem("Serviço testado com sucesso");
        } catch (Exception e) {
            MensagemUtil.mensagem(e.getMessage());
        }
    }

    public void removerServidor(Servidor s) {
        try {
            servico.excluir(s);
            atualizar();
            MensagemUtil.mensagem("Servidor com sucesso");
        } catch (Exception e) {
            MensagemUtil.mensagem(e.getMessage());
        }
    }

}
