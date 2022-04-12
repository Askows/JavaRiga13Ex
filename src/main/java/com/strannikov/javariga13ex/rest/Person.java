package com.strannikov.javariga13ex.rest;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Person {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private long id;

     private String name;

     private int age;



}
