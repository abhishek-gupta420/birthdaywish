package com.abhi.birthdaywish.service;

import jakarta.mail.MessagingException;

import java.io.UnsupportedEncodingException;

public interface DynamicEmailService {
    void sendBirthdayEmail(String to, String name, String message) throws UnsupportedEncodingException, MessagingException;
}
