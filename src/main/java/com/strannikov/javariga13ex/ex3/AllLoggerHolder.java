package com.strannikov.javariga13ex.ex3;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AllLoggerHolder implements CommandLineRunner {

    private final List<DummyLogger> allDummyLogger;

    @Override
    public void run(String... args) throws Exception {
        allDummyLogger.forEach(DummyLogger::sayHello);
        //The same ^^^
//        allDummyLogger.stream().forEach(DummyLogger::sayHello);
//        allDummyLogger.stream().forEach(dummyLogger -> dummyLogger.sayHello());
        
    }
}
