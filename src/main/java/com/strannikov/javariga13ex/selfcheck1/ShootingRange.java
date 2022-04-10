package com.strannikov.javariga13ex.selfcheck1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class ShootingRange implements CommandLineRunner {

    private final Person person;
    private final Enemy enemy;
    private final AnotherEnemy anotherEnemy;
    private final List<Gun> gun;

    @Override
    public void run(String... args) throws Exception {
       if(person.shoot() > enemy.shoot()){
        log.info(person.getClass()+" wins");
       }else {
           log.info(enemy.getClass() +" wins");
       }

    }
}
