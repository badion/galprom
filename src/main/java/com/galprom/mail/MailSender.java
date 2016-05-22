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

public class MailSender {


    private static final Logger LOGGER = Logger.getLogger(MailSender.class);

    private static final String TITLE_FLAG="TITLE_FLAG";
    private static final String TEXT_FLAG="TEXT_FLAG";
    private static final String ITEM_URL_FLAG="ITEM_URL_FLAG";
    private static final String USER_NAME_FLAG="USER_NAME_FLAG";
    private static final String USER_TEL_FLAG="USER_TEL_FLAG";
    private static final String USER_MAIL_FLAG="USER_MAIL_FLAG";

    void sendMail(User user,String text,String itemUrl,String subject) throws MessagingException, IOException, URISyntaxException {
        final Properties props = new Properties();
        props.load(new FileInputStream(getClass().getClassLoader().getResource("mail/mail.smtp.properties").getPath()));
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(props.getProperty("mail.smtp.gmail.user"), props.getProperty("mail.smtp.gmail.pass"));
            }
        });
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("misha.mikus@gmail.com"));
        String responderList = "galprom@i.ua";
        //pass qwedsa
        //link http://www.i.ua/
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(responderList));
        message.setSubject(subject);

        // Send the actual HTML message, as big as you like
        //prepareMessage
        String messageHTML=new String(Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource("mail/template.html").toURI())))
                .replaceAll(TITLE_FLAG,subject)
                .replaceAll(TEXT_FLAG,text)
                .replaceAll(ITEM_URL_FLAG,itemUrl)
                .replaceAll(USER_NAME_FLAG,user.getName())
                .replaceAll(USER_TEL_FLAG,user.getTel())
                .replaceAll(USER_MAIL_FLAG,user.getMail());

        message.setContent(messageHTML, "text/html; charset=utf-8");

        Transport.send(message);
        LOGGER.info("Sent message successfully....");
    }

    public static void main(String[] args) throws MessagingException, IOException, URISyntaxException {
        User user=new User("misha","+380677715633","misha.mikus@gmail.com");
        String text="Хочу купити оцю поїбень.. Скілько скинеш?";
        String itemUrl="http://ru.aliexpress.com/item/8-inches-Dildos-Realistic-Big-Black-Flesh-Brown-Dildo-Flexible-Huge-Penis-with-textured-shaft-and/32241149840.html";
        String subject="Хуй";
        new MailSender().sendMail(user,text,itemUrl,subject);

    }
}
