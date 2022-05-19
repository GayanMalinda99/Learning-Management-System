package com.example.backend.email;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {EmailService.class})
@ExtendWith(SpringExtension.class)
class EmailServiceTest {

    @Autowired
    private EmailService emailService;

    @MockBean
    private JavaMailSender javaMailSender;


    @Test
    void testSend() throws MailException {
        doNothing().when(this.javaMailSender).send((MimeMessage) any());
        when(this.javaMailSender.createMimeMessage()).thenReturn(new MimeMessage((Session) null));
        this.emailService.send("alice.liddell@example.org", "jane.doe@example.org");
        verify(this.javaMailSender).createMimeMessage();
        verify(this.javaMailSender).send((MimeMessage) any());
    }


    @Test
    void testSend2() throws MailException {
        doThrow(new IllegalStateException("utf-8")).when(this.javaMailSender).send((MimeMessage) any());
        when(this.javaMailSender.createMimeMessage()).thenReturn(new MimeMessage((Session) null));
        assertThrows(IllegalStateException.class,
                () -> this.emailService.send("alice.liddell@example.org", "jane.doe@example.org"));
        verify(this.javaMailSender).createMimeMessage();
        verify(this.javaMailSender).send((MimeMessage) any());
    }


    @Test
    @Disabled
    void testSend3() throws MailException {


        doNothing().when(this.javaMailSender).send((MimeMessage) any());
        when(this.javaMailSender.createMimeMessage()).thenReturn(null);
        this.emailService.send("alice.liddell@example.org", "jane.doe@example.org");
    }


    @Test
    void testSend4() throws MailException {
        doNothing().when(this.javaMailSender).send((MimeMessage) any());
        when(this.javaMailSender.createMimeMessage()).thenReturn(new MimeMessage((Session) null));
        assertThrows(IllegalStateException.class,
                () -> this.emailService.send("Confirm Your Email", "jane.doe@example.org"));
        verify(this.javaMailSender).createMimeMessage();
    }

}