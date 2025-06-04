package com.abhi.birthdaywish.service;

public interface DynamicEmailService {
    void sendBirthdayEmail(String to, String name, String message);
}
