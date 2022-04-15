package com.strannikov.javariga13ex.thymeleaf;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Name can not be empty")
    private String name;

    private int age;
    @NotBlank(message = "Pet type can not be empty(CAT,MOUSE)")
    private String type;

}
