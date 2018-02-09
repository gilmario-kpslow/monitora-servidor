package br.gov.ce.caucaia.sefin;

/**
 *
 * @author gilmario
 */
public class Erro {

    private String mensagem;
    private String elemento;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Erro(String mensagem, String elemento) {
        this.mensagem = mensagem;
        this.elemento = elemento;
    }

    public String getElemento() {
        return elemento;
    }

    public Erro(String mensagem) {
        this.mensagem = mensagem;
    }

}
