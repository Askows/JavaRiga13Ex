package com.strannikov.javariga13ex.security;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDataFiller implements CommandLineRunner {

    private final UserRepo userRepo;
    private final BCryptPasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {
        userRepo.saveAll(List.of(
                User.builder()
                        .username("Andrew")
                        .password(encoder.encode("123") )
                        .roles("USER")
                        .build(),
                User.builder()
                        .username("Andrew1")
                        .password(encoder.encode("123") )
                        .roles("ADMIN")
                        .build(),
                User.builder()
                        .username("Andrew2")
                        .password(encoder.encode("123") )
                        .roles("TRAINEE")
                        .build()

        ));
    }
}
