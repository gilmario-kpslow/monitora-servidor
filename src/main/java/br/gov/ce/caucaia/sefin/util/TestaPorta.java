package br.gov.ce.caucaia.sefin.util;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author gilmario
 */
public class TestaPorta {

    public boolean testar(String host, int porta) throws IOException {
        try {
            boolean c;
            try (Socket socket = new Socket(host, porta)) {
                c = socket.isConnected();
            }
            return c;
        } catch (Exception e) {
            return false;
        }
    }
}
