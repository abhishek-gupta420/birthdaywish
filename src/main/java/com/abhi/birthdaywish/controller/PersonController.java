package com.abhi.birthdaywish.controller;

import com.abhi.birthdaywish.entities.Person;
import com.abhi.birthdaywish.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {


    @Autowired
    private PersonService personService;

    @PostMapping("/save")
    public ResponseEntity<String> savePerson(@RequestBody Person person) {
        personService.savePerson(person);
        return ResponseEntity.ok("Person saved successfully!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(
            @PathVariable Long id,
            @RequestBody Person person) {
        return ResponseEntity.ok(personService.updatePerson(id, person));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return ResponseEntity.ok("Person with ID " + id + " has been deleted.");
    }
    @GetMapping("/getallpersons")
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> persons = personService.getAllPersons();
        return ResponseEntity.ok(persons);
    }
    @GetMapping("/greet")
    public String greet(@RequestParam("name") String name) {

        return "Hello " + name;

    }
}
