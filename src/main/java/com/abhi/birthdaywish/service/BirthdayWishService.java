package com.abhi.birthdaywish.service;

import com.abhi.birthdaywish.entities.Person;

import java.util.List;

public interface BirthdayWishService {
    void sendWishesToBirthdayPeople(List<Person> bdayPersonList);
}
