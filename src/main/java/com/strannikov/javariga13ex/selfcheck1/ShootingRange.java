package com.strannikov.javariga13ex.selfcheck1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ShootingRange implements CommandLineRunner {

    private final Person person;

    @Override
    public void run(String... args) throws Exception {
        person.shoot();
    }
}
