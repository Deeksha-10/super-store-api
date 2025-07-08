package com.example.superstore.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendConfirmationEmail(String toEmail, String participantName, String eventName, LocalTime timeSlot) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Event Registration Confirmation");
        
        String formattedTime = timeSlot.format(DateTimeFormatter.ofPattern("h:mm a"));
        String text = String.format(
                "Dear %s,\n\n" +
                "Thank you for registering for the event: %s at %s.\n\n" +
                "We look forward to seeing you there!\n\n" +
                "Best regards,\n" +
                "City Superstore Team",
                participantName, eventName, formattedTime
        );
        
        message.setText(text);
        mailSender.send(message);
    }
}