package com.vswbuildcon.controller;

import com.vswbuildcon.model.Inquiry;
import com.vswbuildcon.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inquiry")
public class InquiryRestController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitInquiry(@RequestBody Inquiry inquiry) {
        try {
            // Process lead (save to db, send emails)
            emailService.processInquiry(inquiry);
            return ResponseEntity.ok("success");
        } catch (MessagingException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("An error occurred during mail transmission.");
        }
    }
}