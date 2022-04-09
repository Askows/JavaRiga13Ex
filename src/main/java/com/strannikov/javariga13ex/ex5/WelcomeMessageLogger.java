package com.strannikov.javariga13ex.ex5;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WelcomeMessageLogger implements CommandLineRunner {
    @Value("${pl.sdacademy.welcome.text.value:none}")
    private String text;
    @Value("${pl.sdacademy.welcome.text.enable}")
    private Boolean shouldLog;

    @Override
    public void run(String... args) throws Exception {
     if(shouldLog){
         log.info(text);
     }
    }
}

