package com.strannikov.javariga13ex.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/login")
    public String loginPage(final ModelMap modelMap){SecurityContextHolder.getContext().getAuthentication().getName();
        return "login";
    }
}
