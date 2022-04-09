package com.strannikov.javariga13ex.ex3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DummyLoggerSecondary implements DummyLogger {
    @Override
    public void sayHello() {
        log.info("Secondary logger");
    }
}
