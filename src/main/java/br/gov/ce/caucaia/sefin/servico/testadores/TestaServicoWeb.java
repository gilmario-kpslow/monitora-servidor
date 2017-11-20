package br.gov.ce.caucaia.sefin.servico.testadores;

import br.gov.ce.caucaia.sefin.servico.Servico;
import br.gov.ce.caucaia.sefin.util.TestaConexaoWeb;
import java.io.IOException;

/**
 *
 * @author gilmario
 */
public class TestaServicoWeb implements TestadorServicoInterface {

    private final TestaConexaoWeb tcw;

    public TestaServicoWeb() {
        tcw = new TestaConexaoWeb();
    }

    @Override
    public boolean testar(Servico servico) throws IOException {
        return tcw.testar(servico.getPath());
    }

}
