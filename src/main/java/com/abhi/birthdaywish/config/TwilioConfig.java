//package com.abhi.birthdaywish.config;
//
//import jakarta.annotation.PostConstruct;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//import com.twilio.Twilio;
//
//
//@Component
//public class TwilioConfig {
//
//    @Autowired
//    NotificationProperties notificationProperties;
//    @Value("${twilio.account.sid}")
//    private String accountSid;
//
//    @Value("${twilio.auth.token}")
//    private String authToken;
//
//    @PostConstruct
//    public void init() {
//        if (notificationProperties.isWhatsappEnabled()) {
//            Twilio.init(accountSid, authToken);
//        } else {
//            System.out.println("WhatsApp notifications are disabled.");
//        }
//    }
//}