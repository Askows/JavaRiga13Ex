package com.strannikov.javariga13ex.ex6;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class RealizeInjection implements CommandLineRunner {
    private final CustomConfigurationComponent customConfigurationComponent;
    @Override
    public void run(String... args) throws Exception {
        log.info(customConfigurationComponent.toString());
    }
}
