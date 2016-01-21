package br.gov.ce.caucaia.sefin.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author gilmario
 */
public class TestaConexaoWeb {

    public boolean testar(String path) throws MalformedURLException, IOException {
        try {
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            int res = connection.getResponseCode();
            connection.disconnect();
            return res == 200;
        } catch (Exception e) {
            return false;
        }
    }
}
