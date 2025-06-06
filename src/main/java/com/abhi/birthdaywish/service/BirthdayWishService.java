package com.abhi.birthdaywish.service;

import com.abhi.birthdaywish.entities.Person;
import jakarta.mail.MessagingException;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface BirthdayWishService {
    void sendWishesToBirthdayPeople(List<Person> bdayPersonList) throws MessagingException, UnsupportedEncodingException;
}
