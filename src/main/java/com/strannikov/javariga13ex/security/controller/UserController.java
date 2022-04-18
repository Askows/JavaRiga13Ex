package com.strannikov.javariga13ex.security.controller;

import com.strannikov.javariga13ex.security.model.Role;
import com.strannikov.javariga13ex.security.model.RoleName;
import com.strannikov.javariga13ex.security.model.User;
import com.strannikov.javariga13ex.security.repository.RoleRepo;
import com.strannikov.javariga13ex.security.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Set;
@Profile("demo")
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final BCryptPasswordEncoder encoder;

    @GetMapping("/login")
    public String loginPage(final ModelMap modelMap){
        SecurityContextHolder.getContext().getAuthentication().getName();
        return "login";
    }
    @GetMapping("/register")
    public String openRegister(final ModelMap modelMap){
        modelMap.addAttribute("emptyUser", new User());
        return "register";

    }


    @PostMapping("/register")
    public String register(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        Role roleOptional = roleRepo.findByName(RoleName.USER.toString());
        user.setRoles(Set.of(roleOptional));
        userRepo.save(user);
        return "redirect:/pet";
    }
}
