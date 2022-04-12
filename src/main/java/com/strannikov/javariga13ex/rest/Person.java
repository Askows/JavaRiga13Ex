package com.strannikov.javariga13ex.rest;

import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Person {
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private long id;
     @NotNull(message = "Required field")
     private String name;
     @Min(value = 18, message = "Minimal age is 18")
     private int age;



}
