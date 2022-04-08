package com.strannikov.javariga13ex.ex2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("DummyLoggerEx2")
@Slf4j
public class DummyLogger {
    public void sayHello() {
        log.info("hello from DummyLogger");
    }
}