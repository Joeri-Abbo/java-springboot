package com.skillsoft.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@Configuration
public class MailController implements CommandLineRunner {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void run(String... args) throws MessagingException, IOException {
        System.out.println("Sending mail...");
        sendEmailWithAttachment();
        sendEmail();
        System.out.println("Done");
    }

    private void sendEmailWithAttachment() throws MessagingException, IOException {
        MimeMessage mimMsg = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimMsg, true);
        mimeMessageHelper.setTo("joeriabbo@hotmail.com");
        mimeMessageHelper.setSubject("Here is a cute photo of a dog!");
        mimeMessageHelper.setText("<h3>Take a look at the attachment: -</h3>", true);

        mimeMessageHelper.addAttachment("cute_dog.jpg", new ClassPathResource("dog.jpg"));

        javaMailSender.send(mimMsg);

    }

    private void sendEmail() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("joeriabbo@hotmail.com");

        msg.setSubject("Email sent using SpringBoot");
        msg.setText("Hello! \n\n Welcome to Spring Boot, easy to send email wasn't it?");
    }
}
