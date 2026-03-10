package com.vswbuildcon.service;

import com.vswbuildcon.model.Inquiry;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    // Recipient address for Admin notifications
    private static final String ADMIN_EMAIL = "contact@2b1.co.in"; // Reusing your existing administrative email

    public void processInquiry(Inquiry inquiry) throws MessagingException {
        
        // 1. (Optional) Save to Database using a Repository. (Skipped for brevity, but model is provided).

        // 2. Automated Admin Notification
        MimeMessage adminMessage = mailSender.createMimeMessage();
        MimeMessageHelper adminHelper = new MimeMessageHelper(adminMessage, true);
        adminHelper.setTo(ADMIN_EMAIL);
        adminHelper.setSubject("New Web Inquiry: " + inquiry.getName());
        adminHelper.setText("Contact Details:\nEmail: " + inquiry.getEmail() + "\nMessage: " + inquiry.getMessage(), true);
        mailSender.send(adminMessage);

        // 3. Automated Customer Thank You (Instant lead nurture)
        MimeMessage customerMessage = mailSender.createMimeMessage();
        MimeMessageHelper customerHelper = new MimeMessageHelper(customerMessage, true);
        customerHelper.setTo(inquiry.getEmail());
        customerHelper.setSubject("Thank You from VSW BUILDCON PVT LTD");
        customerHelper.setText("Dear " + inquiry.getName() + ",<br><br>We have received your inquiry. A member of our team will contact you shortly to discuss your requirement.<br><br>Best Regards,<br>VSW BUILDCON PVT LTD", true);
        mailSender.send(customerMessage);
    }
}