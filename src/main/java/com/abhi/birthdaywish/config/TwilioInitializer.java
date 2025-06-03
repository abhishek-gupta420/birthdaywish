package com.abhi.birthdaywish.config;

import com.abhi.birthdaywish.entities.TwilioConfigEntity;
import com.abhi.birthdaywish.repository.TwilioConfigRepository;
import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwilioInitializer {

    @Autowired
    private TwilioConfigRepository configRepository;

    private String fromNumber;

    @PostConstruct
    public void init() {
        TwilioConfigEntity config = configRepository.findById(1)
                .orElseThrow(() -> new RuntimeException("Twilio config not found in DB"));

        Twilio.init(config.getAccountSid(), config.getAuthToken());
        this.fromNumber = config.getFromNumber();
    }

    public String getFromNumber() {
        return fromNumber;
    }
}
