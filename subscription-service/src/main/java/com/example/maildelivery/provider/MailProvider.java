package com.example.maildelivery.provider;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

@Component
@Slf4j
public class MailProvider {

    @Value("${mail.smtp.port}")
    private Integer port;

    @Value("${mail.smtp.host}")
    private String host;

    @Value("${mail.smtp.username}")
    private String username;

    @Value("${mail.smtp.password}")
    private String password;

    @Value("${mail.smtp.sender}")
    private String sender;

    @Async
    public void sendMail(String title, String content, String receiver) {
        try {
            log.info("========== START SEND MAIL =========");
            log.info("Host: " + host);
            log.info("Port: " + port);
            log.info("User: " + username);
            log.info("Subject: " + title);
            log.info("Sender: " + sender);
            log.info("Receives: " + String.join(";", receiver));
            Properties props = new Properties();
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", port);
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            Authenticator auth = new Authenticator() {
                //override the getPasswordAuthentication method
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, String.valueOf(Base64.decodeBase64(password)));
                }
            };
            Session session = Session.getInstance(props, auth);
            MimeMessage msg = new MimeMessage(session);
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");
            msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));
            msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));
            msg.setSubject(title, "UTF-8");
            msg.setContent(content, "text/html; charset=UTF-8");
            msg.setSentDate(new Date());
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver, false));
            Transport.send(msg);
            log.info("========== END SEND MAIL =========");
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
    }
}
