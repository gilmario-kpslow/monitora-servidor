package br.gov.ce.caucaia.sefin.servico;

import br.gov.ce.caucaia.sefin.servico.testadores.TestaServicoWeb;
import br.gov.ce.caucaia.sefin.servico.testadores.TestaSocket;
import br.gov.ce.caucaia.sefin.servico.testadores.TestadorServicoInterface;

/**
 *
 * @author gilmario
 */
public enum TipoServico {

    WEB(new TestaServicoWeb()), BANCO(new TestaSocket()), OUTROS(new TestaSocket());

    private final TestadorServicoInterface testadorServico;

    private TipoServico(TestadorServicoInterface t) {
        testadorServico = t;
    }

    public boolean testar(Servico servico) throws Exception {
        return testadorServico.testar(servico);
    }
}
