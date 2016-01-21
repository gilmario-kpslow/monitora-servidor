package br.gov.ce.caucaia.sefin.util;

import java.io.IOException;
import java.net.InetAddress;

/**
 *
 * @author gilmario
 */
public class TestadorDePing {

    public boolean testaPing(String ip) throws IOException {
        return InetAddress.getByName(ip).isReachable(5000);
    }
}
