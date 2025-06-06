package com.abhi.birthdaywish.service.impl;

import com.abhi.birthdaywish.config.NotificationProperties;
import com.abhi.birthdaywish.entities.EmailConfig;
import com.abhi.birthdaywish.entities.EmailSendLog;
import com.abhi.birthdaywish.repository.EmailConfigRepository;
import com.abhi.birthdaywish.repository.EmailSendLogRepository;
import com.abhi.birthdaywish.service.DynamicEmailService;
import jakarta.annotation.PostConstruct;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
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

    private static  String USER_NAME;

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
        USER_NAME = config.getUsername();

        mailSender.setHost(config.getHost());
        mailSender.setPort(config.getPort());
        mailSender.setUsername(config.getFromAddress());
        mailSender.setPassword(config.getPassword());

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", config.getProtocol());
        props.put("mail.smtp.auth", String.valueOf(config.isAuthEnabled()));
        props.put("mail.smtp.starttls.enable", String.valueOf(config.isStarttlsEnabled()));
    }
    public void sendBirthdayEmail(String to, String name, String message) throws UnsupportedEncodingException, MessagingException {
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
        String finalMessage = "Dear " + name + ", \n\n" + message;
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        helper.setFrom(new InternetAddress(mailSender.getUsername(), USER_NAME));
        helper.setTo(to);
        helper.setSubject("🎉 \t Happy Birthday " + name);
        helper.setText(finalMessage);
//        mailMessage.setFrom(String.valueOf(new InternetAddress(mailSender.getUsername(), USER_NAME)));
//        mailMessage.setTo(to);
//        mailMessage.setSubject("🎉 \t Happy Birthday " + name);
//        mailMessage.setText("Dear " + name + ",\n\n" + message);
        try {
            mailSender.send(mimeMessage);
            saveEmailLogs(true, finalMessage, mailSender.getUsername(), to, null);

        } catch (Exception e) {
            String error = e.getLocalizedMessage();
            saveEmailLogs(false, finalMessage, mailSender.getUsername(), to, error);
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

    public void saveEmailLogs(Boolean isSuccessful, String mailMessage, String from, String to, String error) {
        EmailSendLog emailSendLog = new EmailSendLog();
        emailSendLog.setEmailMessage(mailMessage);
        emailSendLog.setFromEmail(from);
        emailSendLog.setIsSuccessful(isSuccessful);
        emailSendLog.setSentDttm(new Date());
        emailSendLog.setSentTo(to);
        if (!isSuccessful) {
            emailSendLog.setErrorMessage(error);
        }
        emailSendLogRepository.save(emailSendLog);
    }
}
