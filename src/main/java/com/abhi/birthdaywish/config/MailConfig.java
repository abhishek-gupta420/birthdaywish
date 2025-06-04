package com.abhi.birthdaywish.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSenderImpl javaMailSenderImpl() {
        return new JavaMailSenderImpl(); // We'll configure it dynamically from DB
    }

    @Bean
    public JavaMailSender javaMailSender(JavaMailSenderImpl impl) {
        return impl;
    }
}
