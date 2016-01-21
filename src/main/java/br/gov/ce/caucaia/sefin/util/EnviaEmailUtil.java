package br.gov.ce.caucaia.sefin.util;

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

    public void enviar() throws MessagingException {
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.port", "465");
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("gilmariosoftware@gmail.com", "kpslow0909@WHK");
            }
        });

//        session.setDebug(true);
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("gilmariosoftware@gmail.com"));
        Address[] toUser = InternetAddress.parse("gilmario@sefin.caucaia.ce.gov.br, gilmariosoftware@gmail.com");
        message.setRecipients(Message.RecipientType.TO, toUser);
        message.setSubject("Enviando email com JavaMail");
        message.setText("Enviei este email utilizando JavaMail com minha conta GMail!");
        Transport.send(message, toUser);
        System.out.println("Feito!!!");

    }

}
