package com.strannikov.javariga13ex.selfcheck1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Enemy  {

    private   Gun bigLazer;

    public Enemy(@Qualifier("bigLazer") Gun bigLazer) {
        this.bigLazer = bigLazer;
    }

    public int shoot(){
         return bigLazer.shoot();
    }


    public void setBigLazer(Gun bigLazer) {
        this.bigLazer = bigLazer;
    }
}
