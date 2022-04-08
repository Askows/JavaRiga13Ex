package com.strannikov.javariga13ex.ex2;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandLineRunnerWithConstructorInjection implements CommandLineRunner {
    //Need be FINAL!
    private final DummyLogger dummyLogger;



    @Override
    public void run(final String... args) throws Exception {
        dummyLogger.sayHello("Hello from CommandLineRunnerWithConstructorInjection");
    }
}
