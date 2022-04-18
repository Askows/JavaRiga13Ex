package com.strannikov.javariga13ex.security.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

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

    @OneToMany
    private List<Role> roles;

}
