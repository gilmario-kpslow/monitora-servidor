package br.gov.ce.caucaia.sefin.util;

import java.io.IOException;

/**
 *
 * @author gilmario
 */
public class TestadorDePing {

    public boolean testaPing(String ip) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("ping", "-c", "1", ip);
        Process proc = processBuilder.start();
        return proc.waitFor() == 0;

    }

}
