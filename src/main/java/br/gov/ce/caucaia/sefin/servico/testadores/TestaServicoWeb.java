package br.gov.ce.caucaia.sefin.servico.testadores;

import br.gov.ce.caucaia.sefin.entidade.Servico;
import br.gov.ce.caucaia.sefin.entidade.StatusServico;
import br.gov.ce.caucaia.sefin.util.TestaConexaoWeb;
import java.io.IOException;
import java.util.Calendar;

/**
 *
 * @author gilmario
 */
public class TestaServicoWeb implements TestadorServico {

    private final TestaConexaoWeb tcw;

    public TestaServicoWeb() {
        tcw = new TestaConexaoWeb();
    }

    @Override
    public void testar(Servico servico) throws IOException {
        if (tcw.testar(servico.getPath())) {
            servico.setStatusServico(StatusServico.Ativo);
        } else {
            servico.setStatusServico(StatusServico.Inativo);
        }
        servico.setUltimaResposta(Calendar.getInstance());
    }

}
