package com.strannikov.javariga13ex.ex3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@Slf4j


public class SecondaryLoggerHolder implements CommandLineRunner {


    private final DummyLogger dummyLogger;

    public SecondaryLoggerHolder(@Qualifier("dummyLoggerSecondary")DummyLogger dummyLogger) {
        this.dummyLogger = dummyLogger;
    }

    @Override
    public void run(String... args) throws Exception {
        dummyLogger.sayHello();
    }
}
