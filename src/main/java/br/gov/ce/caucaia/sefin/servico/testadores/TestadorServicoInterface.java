package br.gov.ce.caucaia.sefin.servico.testadores;

import br.gov.ce.caucaia.sefin.servico.Servico;

/**
 *
 * @author gilmario
 */
public interface TestadorServicoInterface {

    public boolean testar(Servico servico) throws Exception;
}
