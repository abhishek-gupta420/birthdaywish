package com.abhi.birthdaywish.service.impl;

import com.abhi.birthdaywish.entities.BdaywishMessage;
import com.abhi.birthdaywish.entities.Person;
import com.abhi.birthdaywish.repository.BdaywishMessageRepository;
import com.abhi.birthdaywish.service.BirthdayWishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BirthdayWishServiceImpl implements BirthdayWishService {



    @Autowired
    private BdaywishMessageRepository messageRepository;

    @Autowired
    private WhatsAppClient whatsAppClient;

    public void sendWishesToBirthdayPeople(List<Person> bdayPersonList) {

//        fetch bday wish message from db
        String message = messageRepository.findById(1L)
                .map(BdaywishMessage::getBirthdayWishMessage)
                .orElse("🎉 Happy Birthday! Wishing you a joyful year ahead!");
        for (Person person : bdayPersonList) {
            whatsAppClient.sendMessage(person.getMobileNumber(), "Hello " + person.getFirstName() + ", " + message);
        }

        System.out.println("✅ Birthday wishes sent to " + bdayPersonList.size() + " person(s).");
    }
}
