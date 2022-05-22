package com.example.backend.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class AnnouncementEmailSender {
    @Autowired
    private JavaMailSender mailSender ;

    public void sendAnnouncement(String receiver, String subject, String body){
        SimpleMailMessage message = new SimpleMailMessage() ;
        message.setFrom("elekstoreteam7@gmail.com");
        message.setTo(receiver);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
        System.out.println("done");
    }
}
