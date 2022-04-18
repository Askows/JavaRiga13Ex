package com.strannikov.javariga13ex.security.service;

import com.strannikov.javariga13ex.security.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String providedUserName) throws UsernameNotFoundException {
        com.strannikov.javariga13ex.security.model.User user = userRepo
                .findById(providedUserName)
                .orElseThrow(() -> new UsernameNotFoundException("User with name " + providedUserName + " not found"));
        List<SimpleGrantedAuthority> authorities =
                user.getRoles()
                        .stream()
                        .map(r -> new SimpleGrantedAuthority("ROLE_"+user.getRoles()))
                        .collect(Collectors.toList());
        return new User(
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }
}
