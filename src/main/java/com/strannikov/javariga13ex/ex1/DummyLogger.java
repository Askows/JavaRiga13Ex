package com.strannikov.javariga13ex.ex1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component
public class DummyLogger implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello from task1");
    }
}
