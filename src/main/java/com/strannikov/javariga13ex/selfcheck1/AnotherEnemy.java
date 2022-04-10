package com.strannikov.javariga13ex.selfcheck1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class AnotherEnemy {

    private final Gun smallLazer;

    public AnotherEnemy(@Qualifier("smallLazer") Gun smallLazer) {
        this.smallLazer = smallLazer;
    }
    public int shoot(){
       return smallLazer.shoot();
    }
}
