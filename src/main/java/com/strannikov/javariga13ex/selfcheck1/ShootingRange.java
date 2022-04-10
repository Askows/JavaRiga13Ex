package com.strannikov.javariga13ex.selfcheck1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
@Slf4j
@RequiredArgsConstructor
public class ShootingRange implements CommandLineRunner {

    private final Person person;
    private final Enemy enemy;
    private final AnotherEnemy anotherEnemy;
    private final List<Gun> weapons;

    @Override
    public void run(String... args) throws Exception {
        Random r =new Random();
        int low = 0;
        int high = 2;
        int result = r.nextInt(high-low)+low;

        enemy.setBigLazer(weapons.get(result));
        result = r.nextInt(high-low)+low;
        person.setLazer(weapons.get(result));
        if(person.shoot() > enemy.shoot()){
        log.info(person.getClass()+" wins");
       }else if(person.shoot() == enemy.shoot()) {
          log.info("both used the same weapon ");
       }else {
            log.info(enemy.getClass() +" wins");
        }

    }
}
