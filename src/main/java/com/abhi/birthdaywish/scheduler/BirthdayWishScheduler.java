package com.abhi.birthdaywish.scheduler;

import com.abhi.birthdaywish.entities.Person;
import com.abhi.birthdaywish.service.BirthdayWishService;
import com.abhi.birthdaywish.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BirthdayWishScheduler {
    @Autowired
    BirthdayWishService birthdayWishService;

    @Autowired
    private PersonService personService;

    // This scheduler runs every day at 7:00 AM
    @Scheduled(cron = "0 0 0 * * ?")
    public void runBirthdayWishScheduler() {
        List<Person> birthdayPersons = personService.getListOfPersonHavingBdayToday();

        if (birthdayPersons.isEmpty()) {
            System.out.println("🎂 No birthdays today.");
        } else {
                birthdayWishService.sendWishesToBirthdayPeople(birthdayPersons);
        }
    }
}