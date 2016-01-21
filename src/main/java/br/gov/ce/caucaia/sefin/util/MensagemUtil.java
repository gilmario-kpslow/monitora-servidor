package br.gov.ce.caucaia.sefin.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author gilmario
 */
public class MensagemUtil {

    public static void mensagem(String titulo, String mensagem) {
        gerar(titulo, mensagem, FacesMessage.SEVERITY_INFO);
    }

    public static void mensagem(String titulo, String mensagem, FacesMessage.Severity severidade) {
        gerar(titulo, mensagem, severidade);
    }

    public static void mensagem(String mensagem) {
        gerar("Informação", mensagem, FacesMessage.SEVERITY_INFO);
    }

    public static void gerar(String titulo, String mensagem, FacesMessage.Severity severidade) {
        FacesContext.getCurrentInstance().addMessage("", new FacesMessage(severidade, titulo, mensagem));
    }
}
