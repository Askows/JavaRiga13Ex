package com.strannikov.javariga13ex.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")

public class TestApi {
    private List<Person> db = new ArrayList<>();


    //GET!!!
    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable("name") String firstName) {
        return "Hello " + firstName;
    }

    ///SAVE!
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
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
        return person;
    }

    @GetMapping
    public List<Person> getAll() {
        return db;
    }
        //DELETE
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
