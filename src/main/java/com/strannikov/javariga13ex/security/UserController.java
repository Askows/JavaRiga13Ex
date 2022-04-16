package com.strannikov.javariga13ex.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepo userRepo;
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
        user.setRoles("USER");
        userRepo.save(user);
        return "redirect:/pet";
    }
}
