package com.galprom.mail;

import org.apache.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import static java.nio.file.Files.*;

public class MailSender {

    private static final Logger LOGGER = Logger.getLogger(MailSender.class);

    private static final String TITLE_FLAG = "TITLE_FLAG";
    private static final String TEXT_FLAG = "TEXT_FLAG";
    private static final String ITEM_URL_FLAG = "ITEM_URL_FLAG";
    private static final String USER_NAME_FLAG = "USER_NAME_FLAG";
    private static final String USER_TEL_FLAG = "USER_TEL_FLAG";
    private static final String USER_MAIL_FLAG = "USER_MAIL_FLAG";

    public void sendMail(User user, String text, String itemUrl, String subject) throws MessagingException, IOException, URISyntaxException {
        LOGGER.info("START send Message");
        LOGGER.info(user);
        LOGGER.info("MessageText : " + text);
        LOGGER.info("itemUrl : " + itemUrl);
        LOGGER.info("subject : " + subject);

        Properties props = new Properties();
        props.load(new FileInputStream(getClass().getClassLoader().getResource("mail/mail.smtp.properties").getPath()));
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        final String from = props.getProperty("mail.smtp.gmail.user");
        final String fromPass = props.getProperty("mail.smtp.gmail.pass");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, fromPass);
            }
        });
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from + "@gmail.com"));

        String responderList = "galprom@i.ua";

        //user galprom
        //pass qwedsa
        //link http://www.i.ua/

        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(responderList));
        message.setSubject(subject);

        String messageHTML = new String(readAllBytes(Paths.get(getClass().getClassLoader().getResource("mail/template.html").toURI())))
                .replaceAll(TITLE_FLAG, subject)
                .replaceAll(TEXT_FLAG, text)
                .replaceAll(ITEM_URL_FLAG, itemUrl)
                .replaceAll(USER_NAME_FLAG, user.getName())
                .replaceAll(USER_TEL_FLAG, user.getTel())
                .replaceAll(USER_MAIL_FLAG, user.getMail());

        message.setContent(messageHTML, "text/html; charset=utf-8");

        Transport.send(message);
        LOGGER.info("Sent message successfully....");
    }

    public void makeSender(User user, String comment, String itemUrl, String subject) throws MessagingException, IOException, URISyntaxException {
        new Thread(() -> {
            try {
                sendMail(user,comment,itemUrl,subject);
            } catch (MessagingException | IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
