package com.strannikov.javariga13ex.rest;

import lombok.Data;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

@Data
public class Person {
     private String name;
     private int age;

     public void setName(String name) {
          this.name = name;
     }

     public void setAge(int age) {
          this.age = age;
     }
}
