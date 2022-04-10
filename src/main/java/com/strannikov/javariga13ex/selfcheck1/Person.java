package com.strannikov.javariga13ex.selfcheck1;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person  {


    private  Gun lazer;

    public Person(@Qualifier("lazer") Gun lazer) {
        this.lazer = lazer;
    }

    public int shoot(){
       return lazer.shoot();
   }

    public void setLazer(Gun lazer) {
        this.lazer = lazer;
    }


}
