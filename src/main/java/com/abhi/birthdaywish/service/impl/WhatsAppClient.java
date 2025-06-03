package com.abhi.birthdaywish.service.impl;

import org.springframework.stereotype.Component;

@Component
public class WhatsAppClient {

    public void sendMessage(String mobileNumber, String message) {
        // Replace this with actual WhatsApp API integration (e.g., Twilio)
        System.out.println("📲 Sending WhatsApp message to " + mobileNumber + ": " + message);
    }
}