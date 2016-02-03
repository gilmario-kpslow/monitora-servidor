package br.gov.ce.caucaia.sefin.util;

import com.sun.mail.util.MailSSLSocketFactory;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author gilmario
 */
public class EnviaEmailUtil {

    private final Properties properties;
    private Session session;

    public EnviaEmailUtil() {
        properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.host", "mail.sefin.caucaia.ce.gov.br");
        properties.setProperty("mail.smtp.ssl.trust", "mail.sefin.caucaia.ce.gov.br");
        properties.setProperty("mail.smtp.starttls.required", "true");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.port", "587");
        session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("notacaucaia@sefin.caucaia.ce.gov.br", "s2014n");
            }
        });
    }

    public void enviar(String destinatarios, String assunto, String mensagem) throws MessagingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("monitor-sefin@sefin.caucaia.ce.gov.br"));
        Address[] toUser = InternetAddress.parse(destinatarios);
        message.setSubject(assunto);
        message.setText(mensagem);
        Transport.send(message, toUser);
    }

}
