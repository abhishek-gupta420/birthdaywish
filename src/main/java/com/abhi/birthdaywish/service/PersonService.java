package com.abhi.birthdaywish.service;

import com.abhi.birthdaywish.entities.Person;

import java.util.List;

public interface PersonService {
    Person savePerson(Person person);
    Person updatePerson(Long id, Person person);
    void deletePerson(Long id);
    List<Person> getAllPersons();
    List<Person> getListOfPersonHavingBdayToday();

}
