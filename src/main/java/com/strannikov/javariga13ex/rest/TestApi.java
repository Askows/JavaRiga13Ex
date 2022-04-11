package com.strannikov.javariga13ex.rest;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestApi {


    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello " + name;
    }

    @PostMapping()
    public Person saveName(@RequestBody Person person) {

        return person;
    }
}
