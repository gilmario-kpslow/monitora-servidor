package br.gov.ce.caucaia.sefin.servico.testadores;

import br.gov.ce.caucaia.sefin.util.TestadorDePing;
import br.gov.ce.caucaia.sefin.entidade.StatusServidor;
import br.gov.ce.caucaia.sefin.entidade.Servidor;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author gilmario
 */
public class TestadorServidor implements Serializable {

    private final TestadorDePing ping;

    public TestadorServidor() {
        ping = new TestadorDePing();
    }

    public void testar(Servidor servidor) throws IOException {
        if (ping.testaPing(servidor.getIp())) {
            servidor.setStatus(StatusServidor.Ativo);
        } else {
            servidor.setStatus(StatusServidor.Inativo);
        }
        servidor.setUltimoTeste(Calendar.getInstance());
    }

}
