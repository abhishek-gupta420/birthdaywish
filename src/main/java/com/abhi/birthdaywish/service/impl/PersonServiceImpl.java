package com.abhi.birthdaywish.service.impl;

import com.abhi.birthdaywish.entities.Person;
import com.abhi.birthdaywish.repository.PersonRepository;
import com.abhi.birthdaywish.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person savePerson(Person person) {
        person.setInsertedDate(LocalDateTime.now());
        person.setInsertedBy("SYSTEM");
        return personRepository.save(person);
    }


    public List<Person> getListOfPersonHavingBdayToday() {
//        get month return 0-11 where 0 -jan and dec - 11 so, adding + 1 to get current month as per calender
        return personRepository.findBirthdayMatches(new Date().getMonth() + 1, new Date().getDate());
    }

    @Override
    public Person updatePerson(Long id, Person personDTO) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found with ID: " + id));

        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());
        person.setMobileNumber(personDTO.getMobileNumber());
        person.setEmailId(personDTO.getEmailId());
        if (personDTO.getDob() != null) {
            person.setDob(LocalDate.parse(personDTO.getDob().toString()));
        }
        person.setUpdatedDate(LocalDateTime.now());
        person.setUpdatedBy("system"); // You can customize this

        return personRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        if (!personRepository.existsById(id)) {
            throw new RuntimeException("Person not found with ID: " + id);
        }
        personRepository.deleteById(id);
    }
    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

}
