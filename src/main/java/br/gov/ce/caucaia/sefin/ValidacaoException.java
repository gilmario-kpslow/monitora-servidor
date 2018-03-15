package br.gov.ce.caucaia.sefin;

import java.util.List;

/**
 *
 * @author gilmario
 */
public class ValidacaoException extends Exception {

    private final List<Erro> erros;

    public ValidacaoException(List<Erro> erros) {
        super();
        this.erros = erros;
    }

    public List<Erro> getErros() {
        return erros;
    }

}
