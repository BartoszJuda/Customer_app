package com.project.controllers.rest;

import com.project.email.EmailCfg;
import com.project.email.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RestController
@CrossOrigin
public class FeedbackRestController {

    private EmailCfg emailCfg;
    private JavaMailSender javaMailSender;

    @Autowired
    public FeedbackRestController(EmailCfg emailCfg, JavaMailSender javaMailSender) {
        this.emailCfg = emailCfg;
        this.javaMailSender = javaMailSender;
    }

    public FeedbackRestController() {
    }

    @PostMapping("/feedback")
    public String sendEmail(@RequestBody Feedback feedback) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(feedback.getEmail());
        message.setSubject(feedback.getName());
        message.setText(feedback.getFeedback());
        javaMailSender.send(message);
        return "Send successfully!";
    }

    @PostMapping("/feedbackAttachment")
    public String sendEmailWithAttachment(@RequestBody Feedback feedback) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(feedback.getEmail());
        helper.setSubject("Link report");
        helper.setFrom("NoReply@application.com");
        helper.setText("This is your report!");

        ClassPathResource path = new ClassPathResource("links.xls");
        helper.addAttachment("links.xlsx", path);

        javaMailSender.send(message);
        return "Send successfully!";
    }
}
