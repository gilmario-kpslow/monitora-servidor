package br.gov.ce.caucaia.sefin.servico.testadores;

import br.gov.ce.caucaia.sefin.servico.Servico;
import br.gov.ce.caucaia.sefin.util.TestaPorta;
import java.io.IOException;

/**
 *
 * @author gilmario
 */
public class TestaSocket implements TestadorServicoInterface {

    private final TestaPorta testaPorta;

    public TestaSocket() {
        testaPorta = new TestaPorta();
    }

    @Override
    public boolean testar(Servico servico) throws IOException {
        return testaPorta.testar(servico.getServidor().getIp(), servico.getPorta());
    }

}
