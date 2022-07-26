package com.codecool.shop.controller;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.Address;
import javax.mail.MessagingException;
import java.util.Properties;

public class EmailSender {

    private JavaMailSenderImpl mailSender;

    private Properties properties;

    public EmailSender() {
        this.mailSender = new JavaMailSenderImpl();
        this.properties = new Properties();
        setProperties();
    }

    private void setProperties() {
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "8080");
        properties.put("mail.smtp.ssl.enable", "true");

        mailSender.setJavaMailProperties(properties);

        // authentication
        mailSender.setUsername("");
        mailSender.setPassword("");
    }

    public void createMessage() throws MessagingException {
        javax.mail.internet.MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("papp.csenge0@gmail.com");
        helper.setSubject("You order");
        helper.setText("text", true);
        helper.addTo("papp.csenge0@gmail.com");

        mailSender.send(message);
    }




}
