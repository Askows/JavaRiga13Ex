package com.strannikov.javariga13ex.selfcheck1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Lazer implements Gun {
    @Value("${lazer.shoot.sound:Pew Pew}")
    private String shootingSound;
    public void shoot(){
        log.info(shootingSound);
    }
}
