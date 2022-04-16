package com.strannikov.javariga13ex.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String providedUserName) throws UsernameNotFoundException {
        com.strannikov.javariga13ex.security.User user = userRepo
                .findById(providedUserName)
                .orElseThrow(() -> new UsernameNotFoundException("User with name " + providedUserName + " not found"));
        return new User(
                user.getUsername(),
                user.getPassword(),
                List.of(
                        new SimpleGrantedAuthority(user.getRoles()))
        );
    }
}
