package com.example.filmy;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Aspect
@Component
public class FilmEmailAspect {

    @Value("${recipient}")
    private String mailTo;

    private final MailService mailService;

    @Autowired
    public FilmEmailAspect(MailService mailService) {
        this.mailService = mailService;
    }

    @After("@annotation(FilmAspect)")
    private void afterPost() throws MessagingException {
        mailService.sendMail(mailTo, "Nowy film!", "Uwaga, dodano nowy film!", false);
        System.out.println("Wysłałem maila!");
    }
}
