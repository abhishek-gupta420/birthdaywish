package com.abhi.birthdaywish.controller;

import com.abhi.birthdaywish.entities.Person;
import com.abhi.birthdaywish.service.BirthdayWishService;
import com.abhi.birthdaywish.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/wish")
public class BirthDayWishController {
    @Autowired
    PersonService personService;

    @Autowired
    BirthdayWishService birthdayWishService;
    @GetMapping
    public void wishHappyBday() {
        List<Person> list = personService.getListOfPersonHavingBdayToday();
        birthdayWishService.sendWishesToBirthdayPeople(list);
    }
}
