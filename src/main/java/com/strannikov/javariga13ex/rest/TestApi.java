package com.strannikov.javariga13ex.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class TestApi {
    //Repository wich work with dataBase
    private final PersonRepository personRepository;

    //GET!!!
    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable("name") String firstName) {
        return "Hello " + firstName;
    }

    ///SAVE!
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Person saveName(@RequestBody Person person) {

        return personRepository.save(person);
    }

    // UPDATE!!!
    @PutMapping("/{name}")
    public String updateAllPersonsWithName(@PathVariable("name") String firstName,
                                           @RequestBody Person person) {
        //1. Find all persons with firstname
        //Also add function findByname to PersonRepository
        List<Person> allPersonsWithName
                = personRepository.findByName(firstName);

        //Create new list with changed persons
        //Used stream all new date get from Request body
        //And Save in new List!
        List<Person> newPersons = allPersonsWithName
                .stream().map(personFromList -> {
                    personFromList.setAge(person.getAge());
                    personFromList.setName(person.getName());
                    return personFromList;
                })
                .collect(Collectors.toList());

        personRepository.saveAll(newPersons);
        return "Updated";
    }

    @GetMapping
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    //DELETE
    @DeleteMapping("/{name}")
    public String delete(@PathVariable("name") String firstName) {
        List<Person> person = personRepository.findByName(firstName);

        if (person != null && person.size() > 0) {
            personRepository.deleteAll(person);
            return "Deleted";
        }

        return "Not deleted";
    }
}
