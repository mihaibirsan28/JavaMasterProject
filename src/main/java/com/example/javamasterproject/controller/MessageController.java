package com.example.javamasterproject.controller;

//import com.example.licenta.model.Message;
//import com.example.licenta.repository.MessageRepository;
//import org.springframework.beans.factory.annotation.Autowired;      // For autowiring dependencies
//import org.springframework.boot.SpringApplication;                 // For starting the Spring Boot application
//import org.springframework.boot.autoconfigure.SpringBootApplication;           // For auto-configuration of the Spring Boot application
//import org.springframework.context.annotation.Bean;                  // For defining beans
//import org.springframework.http.ResponseEntity;                    // For representing HTTP responses
//import org.springframework.mail.SimpleMailMessage;                // For sending simple email messages
//import org.springframework.mail.javamail.JavaMailSender;          // For sending emails using JavaMail
//import org.springframework.stereotype.Controller;                  // For defining controller classes
//import org.springframework.web.bind.annotation.*;                  // For defining RESTful APIs
//
//import javax.mail.internet.MimeMessage;                          // For sending MIME email messages
//import org.springframework.mail.javamail.MimeMessageHelper;       // For sending MIME email messages using JavaMail

import com.example.javamasterproject.dto.MessageDTO;
import com.example.javamasterproject.repository.MessageRepository;
import com.example.javamasterproject.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/messages")
public class MessageController {
    private final MessageRepository messageRepository;

    @Autowired
    private MessageService messageService;

//    private final JavaMailSender javaMailSender;
//
//    public MessageController(MessageRepository messageRepository, JavaMailSender javaMailSender) {
//        this.messageRepository = messageRepository;
//        this.javaMailSender = javaMailSender;
//    }

    @PostMapping("")
    public ResponseEntity<MessageDTO> createMessage(@RequestBody MessageDTO messageDTO) {
        String createdMessage = messageService.createMessage(messageDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(messageService.getMessageById(createdMessage));
    }

    @GetMapping("/all")
    public ResponseEntity<List<MessageDTO>> getAllMessages() {
        List<MessageDTO> messageDTOS = messageService.getAllMessages();
        return ResponseEntity.ok(messageDTOS);
    }

//    @PostMapping("/send-email/email={email}")
//    public ResponseEntity<String> sendEmail(@PathVariable String email, @RequestBody Message message) {
//        messageRepository.save(message);
//
//        // Send email
//        MimeMessage emailMessage = javaMailSender.createMimeMessage();
//        MimeMessageHelper helper;
//
//        try {
//            helper = new MimeMessageHelper(emailMessage);
//            helper.setTo(email);
//            helper.setSubject("Subject: " + message.getSubject());
//            helper.setText("Name: " + message.getName() + "\nEmail: " + email +
//                    "\nSubject: " + message.getSubject() + "\nMessage: " + message.getMessage());
//
//            javaMailSender.send(emailMessage);
//        } catch (MessagingException e) {
//            // Handle the exception
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email");
//        }
//
//        return ResponseEntity.ok("Message sent successfully");
//    }

}
