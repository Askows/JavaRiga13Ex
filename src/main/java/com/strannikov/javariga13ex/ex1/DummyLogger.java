package com.strannikov.javariga13ex.ex1;

import jdk.jfr.Name;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;



@Component("DummyLoggerEx1")
@Slf4j
public class DummyLogger implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Hello from task1");
        //log use because added Slf4J it better than System.out.println()
        log.info("Hello from task1");
    }
}
