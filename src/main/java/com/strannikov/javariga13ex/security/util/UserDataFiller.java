package com.strannikov.javariga13ex.security.util;


import com.strannikov.javariga13ex.security.model.Role;
import com.strannikov.javariga13ex.security.model.RoleName;
import com.strannikov.javariga13ex.security.model.User;
import com.strannikov.javariga13ex.security.repository.RoleRepo;
import com.strannikov.javariga13ex.security.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class UserDataFiller implements CommandLineRunner {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final BCryptPasswordEncoder encoder;

    @Override
    public void run(String... args) throws Exception {

       List<Role> roles =  roleRepo
                .saveAll(List.of(Role.builder()
                        .name(RoleName.USER.toString())
                        .build()));

        if(roles==null){
            log.error("Roles not saved");
            return;
        }
        log.info("Roles not saved");

        userRepo.saveAll(List.of(
                User.builder()
                        .username("Andrew")
                        .password(encoder.encode("123") )
                        .roles(roles)
                        .build(),
                User.builder()
                        .username("Andrew1")
                        .password(encoder.encode("123") )
                        .roles(List.of(roles.get(0)))
                        .build(),
                User.builder()
                        .username("Andrew2")
                        .password(encoder.encode("123") )
                        .roles(List.of(roles.get(1)))
                        .build()

        ));
    }
}
