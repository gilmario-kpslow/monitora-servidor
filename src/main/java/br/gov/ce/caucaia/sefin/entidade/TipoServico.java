package br.gov.ce.caucaia.sefin.entidade;

import br.gov.ce.caucaia.sefin.servico.testadores.TestaServicoWeb;
import br.gov.ce.caucaia.sefin.servico.testadores.TestaSocket;
import br.gov.ce.caucaia.sefin.servico.testadores.TestadorServico;

/**
 *
 * @author gilmario
 */
public enum TipoServico {

    Web(new TestaServicoWeb()), Banco(new TestaSocket()), Outros(new TestaSocket());

    private final TestadorServico testadorServico;

    private TipoServico(TestadorServico t) {
        testadorServico = t;
    }

    public void testar(Servico servico) throws Exception {
        testadorServico.testar(servico);
    }
}
