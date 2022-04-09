package com.strannikov.javariga13ex.ex4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("DummyLoggerEx4")
@Slf4j
public class DummyLogger {

    private void sayHi() {
        log.info("Hi from zadanie4");
    }
}
