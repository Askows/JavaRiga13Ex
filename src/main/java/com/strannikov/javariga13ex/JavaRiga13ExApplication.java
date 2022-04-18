package com.strannikov.javariga13ex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableGlobalMethodSecurity(securedEnabled = true)
@SpringBootApplication
public class JavaRiga13ExApplication {

    public static void main(String[] args) {
 SpringApplication.run(JavaRiga13ExApplication.class, args);
    }

}
