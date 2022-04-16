package com.strannikov.javariga13ex.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;

@Component
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {


    @Id
    private String username;

    private String password;

    private String roles;

}
