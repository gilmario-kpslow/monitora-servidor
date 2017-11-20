package br.gov.ce.caucaia.sefin;

import br.gov.ce.caucaia.sefin.servico.Servico;
import br.gov.ce.caucaia.sefin.servico.ServicoServico;
import br.gov.ce.caucaia.sefin.servico.testadores.TestadorServico;
import br.gov.ce.caucaia.sefin.servidor.Servidor;
import br.gov.ce.caucaia.sefin.servidor.ServidorServico;
import br.gov.ce.caucaia.sefin.servidor.TestadorServidor;
import br.gov.ce.caucaia.sefin.util.MensagemUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.mail.MessagingException;

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
    @EJB
    private TestadorServico testadorServico;
    @EJB
    private TestadorServidor testadorServidor;
    private Date data;

    @PostConstruct
    private void init() {
        pagina = "board";
        listaDeServidores = servico.buscar();
    }

    public List<Servico> countarServicos(Servidor s) {
        return servicoServico.buscar(s);
    }

    public List<Servico> countarServicosAtivos(Servidor s) {
        return servicoServico.buscarAtivos(s);
    }

    public void atualizar() {
        init();
        data = new Date();
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
            testadorServidor.testar(servidor);
            atualizar();
            MensagemUtil.mensagem("Servidor testado com sucesso");
        } catch (IOException | MessagingException | InterruptedException e) {
            MensagemUtil.mensagem(e.getMessage());
        }
    }

    public void testarServico(Servico s) {
        try {
            testadorServico.testar(s);
            atualizar();
            MensagemUtil.mensagem("Serviço testado com sucesso");
        } catch (Exception e) {
            MensagemUtil.mensagem(e.getMessage());
        }
    }

    public void removerServidor(Servidor s) {
        try {
            listaDeServidores.remove(s);
            servico.excluir(s);
            atualizar();
            MensagemUtil.mensagem("Servidor com sucesso");
        } catch (Exception e) {
            MensagemUtil.mensagem(e.getMessage());
        }
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

}
