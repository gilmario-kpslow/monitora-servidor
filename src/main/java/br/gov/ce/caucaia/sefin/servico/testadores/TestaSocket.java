package br.gov.ce.caucaia.sefin.servico.testadores;

import br.gov.ce.caucaia.sefin.entidade.Servico;
import br.gov.ce.caucaia.sefin.entidade.StatusServico;
import br.gov.ce.caucaia.sefin.util.TestaPorta;
import java.io.IOException;
import java.util.Calendar;

/**
 *
 * @author gilmario
 */
public class TestaSocket implements TestadorServico {

    private final TestaPorta testaPorta;

    public TestaSocket() {
        testaPorta = new TestaPorta();
    }

    @Override
    public void testar(Servico servico) throws IOException {
        if (testaPorta.testar(servico.getServidor().getIp(), servico.getPorta())) {
            servico.setStatusServico(StatusServico.Ativo);
        } else {
            servico.setStatusServico(StatusServico.Inativo);
        }
        servico.setUltimaResposta(Calendar.getInstance());
    }

}
