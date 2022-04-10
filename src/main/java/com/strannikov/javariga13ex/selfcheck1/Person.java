package com.strannikov.javariga13ex.selfcheck1;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@RequiredArgsConstructor
public class Person  {

   private final  Gun lazer;

   public void shoot(){
       lazer.shoot();
   }




}
