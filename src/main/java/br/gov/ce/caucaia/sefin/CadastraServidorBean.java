package br.gov.ce.caucaia.sefin;

import br.gov.ce.caucaia.sefin.servidor.Servidor;
import br.gov.ce.caucaia.sefin.servidor.ServidorServico;
import br.gov.ce.caucaia.sefin.servidor.TipoServidor;
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
public class CadastraServidorBean implements Serializable {

    @EJB
    private ServidorServico servico;
    @Inject
    private DashBoard board;
    private Servidor servidor;

    @PostConstruct
    private void init() {
        servidor = new Servidor();
    }

    public void salvar() {
        try {
            servico.salvar(servidor);
            board.atualizar();
            servidor = new Servidor();
            MensagemUtil.mensagem("servidor registrado");
        } catch (Exception e) {
            MensagemUtil.mensagem("Erro", e.getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }

    public List<TipoServidor> getTipos() {
        return Arrays.asList(TipoServidor.values());
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

}
