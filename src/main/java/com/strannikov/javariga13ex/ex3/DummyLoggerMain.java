package com.strannikov.javariga13ex.ex3;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Primary
public class DummyLoggerMain implements DummyLogger {
    @Override
    public void sayHello() {
      log.info("Main logger");
    }
}
