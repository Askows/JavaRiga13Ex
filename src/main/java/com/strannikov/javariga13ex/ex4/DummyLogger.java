package com.strannikov.javariga13ex.ex4;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component("DummyLoggerEx4")
@Slf4j
public class DummyLogger {

    public void sayHi(int result, String sentence) {
        log.info(result + " " + sentence);
    }
}
