package com.abhi.birthdaywish.service.impl;

import com.abhi.birthdaywish.config.TwilioInitializer;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WhatsAppClient {

    private final String signature = "\n\n— Abhishek Gupta";
    @Autowired
    private TwilioInitializer twilioInitializer;
    public void sendMessage(String toMobileNumber, String message) {
        // Replace this with actual WhatsApp API integration (e.g., Twilio)
        Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:" + toMobileNumber),
                new com.twilio.type.PhoneNumber(twilioInitializer.getFromNumber()),
                message + signature
        ).create();
        System.out.println("📲 Sending WhatsApp message to " + toMobileNumber + ": " + message);
    }
}