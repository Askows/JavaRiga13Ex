package com.strannikov.javariga13ex.ex8;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RestApi {

    private final RandomBooleanProvider randomBooleanProvider;

    @GetMapping("/api/random-boolean")
    public Boolean getRandomBoolean(){
        return  randomBooleanProvider.getValue() ;
    }
}
