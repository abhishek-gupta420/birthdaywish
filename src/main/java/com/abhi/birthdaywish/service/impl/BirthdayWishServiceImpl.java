package com.abhi.birthdaywish.service.impl;

import com.abhi.birthdaywish.config.NotificationProperties;
import com.abhi.birthdaywish.entities.BdaywishMessage;
import com.abhi.birthdaywish.entities.Person;
import com.abhi.birthdaywish.repository.BdaywishMessageRepository;
import com.abhi.birthdaywish.service.BirthdayWishService;
import jakarta.annotation.PostConstruct;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.List;

@Service
public class BirthdayWishServiceImpl implements BirthdayWishService {



    @Autowired
    private BdaywishMessageRepository messageRepository;

    @Autowired
    private WhatsAppClient whatsAppClient;

    @Autowired
    DynamicEmailServiceImpl dynamicEmailService;

    @Autowired
    NotificationProperties notificationProperties;

    public void sendWishesToBirthdayPeople(List<Person> bdayPersonList) throws MessagingException, UnsupportedEncodingException {

//        fetch bday wish message from db
        String message = messageRepository.findById(1L)
                .map(BdaywishMessage::getBirthdayWishMessage)
                .orElse("🎉 Happy Birthday! Wishing you a joyful year ahead!");

        for (Person person : bdayPersonList) {
            if (notificationProperties.isWhatsappEnabled()) {
                whatsAppClient.sendMessage(person.getMobileNumber(), "Hi " + person.getFirstName() + " " +person.getLastName() + ", " + message);
            }

            if (notificationProperties.isEmailEnabled()) {
                dynamicEmailService.sendBirthdayEmail(person.getEmailId(), person.getFirstName() + " " + person.getLastName(), message);
            }
        }

        System.out.println("✅ Birthday wishes sent to " + bdayPersonList.size() + " person(s).");
    }

    @PostConstruct
    public void printFlags() {
        System.out.println("WhatsApp enabled: " + notificationProperties.isWhatsappEnabled());
        System.out.println("Email enabled: " + notificationProperties.isEmailEnabled());
    }
}
