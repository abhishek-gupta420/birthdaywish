package com.abhi.birthdaywish.service.impl;

import com.abhi.birthdaywish.config.NotificationProperties;
import com.abhi.birthdaywish.entities.EmailConfig;
import com.abhi.birthdaywish.entities.EmailSendLog;
import com.abhi.birthdaywish.repository.EmailConfigRepository;
import com.abhi.birthdaywish.repository.EmailSendLogRepository;
import com.abhi.birthdaywish.service.DynamicEmailService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Properties;

@Service
public class DynamicEmailServiceImpl implements DynamicEmailService {


    @Autowired
    private JavaMailSenderImpl mailSender;

    @Autowired
    private EmailConfigRepository emailConfigRepo;

    @Autowired
    private NotificationProperties notificationProperties;

    @Autowired
    EmailSendLogRepository emailSendLogRepository;

    @PostConstruct
    public void init() {
        if (notificationProperties.isEmailEnabled()) {
            loadEmailSettings();
        } else {
            System.out.println("Email notification is disabled. Skipping config load.");
        }
    }

    private void loadEmailSettings() {
        EmailConfig config = emailConfigRepo.findById(1).orElseThrow();

        mailSender.setHost(config.getHost());
        mailSender.setPort(config.getPort());
        mailSender.setUsername(config.getUsername());
        mailSender.setPassword(config.getPassword());

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", config.getProtocol());
        props.put("mail.smtp.auth", String.valueOf(config.isAuthEnabled()));
        props.put("mail.smtp.starttls.enable", String.valueOf(config.isStarttlsEnabled()));
    }
    public void sendBirthdayEmail(String to, String name, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(mailSender.getUsername());
        mailMessage.setTo(to);
        mailMessage.setSubject("🎉 \t Happy Birthday " + name);
        mailMessage.setText("Dear " + name + ",\n\n" + message);
        try {
            mailSender.send(mailMessage);
            saveEmailLogs(true, mailMessage, null);

        } catch (Exception e) {
            String error = e.getLocalizedMessage();
            saveEmailLogs(false, mailMessage, error);
        }
    }

    public void saveEmailLogs(Boolean isSuccessful, SimpleMailMessage mailMessage, String error) {
        EmailSendLog emailSendLog = new EmailSendLog();
        emailSendLog.setEmailMessage(mailMessage.getText());
        emailSendLog.setFromEmail(mailMessage.getFrom());
        emailSendLog.setIsSuccessful(isSuccessful);
        emailSendLog.setSentDttm(new Date());
        emailSendLog.setSentTo(mailMessage.getTo()[0]);
        if (!isSuccessful) {
            emailSendLog.setErrorMessage(error);
        }
        emailSendLogRepository.save(emailSendLog);
    }
}
