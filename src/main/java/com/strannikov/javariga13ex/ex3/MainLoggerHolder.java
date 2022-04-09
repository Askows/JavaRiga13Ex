package com.strannikov.javariga13ex.ex3;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MainLoggerHolder  implements CommandLineRunner {
        //FINAL!!!!!!
    private final DummyLogger dummyLogger;

    @Override
    public void run(String... args) throws Exception {
        dummyLogger.sayHello();
    }
}
