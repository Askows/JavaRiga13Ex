package com.strannikov.javariga13ex.rest;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestApi {
    private List<Person> db = new ArrayList<>();


    //GET!!!
    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable("name") String firstName) {
        return "Hello " + firstName;
    }

    ///SAVE!
    @PostMapping()
    public Person saveName(@RequestBody Person person) {
        db.add(person);
        return person;
    }

    // UPDATE!!!
    @PutMapping("/{name}")
    public Person updateName(@PathVariable("name") String firstName,
                             @RequestBody Person person) {
        for (Person person1 : db) {
            if (person1.getName().equals(firstName)) {
                person1.setName(person.getName());
                person1.setAge(person.getAge());

            }
        }
        person.setName(firstName);
        return person;
    }

    @GetMapping
    public List<Person> getAll() {
        return db;
    }

    @DeleteMapping("/{name}")
    public String delete(@PathVariable("name") String firstName) {
        for (Person person1 : db) {
            if (person1.getName().equals(firstName)) {
                db.remove(person1);
                return "Deleted";
            }
        }
        return "Not deleted";
    }
}
