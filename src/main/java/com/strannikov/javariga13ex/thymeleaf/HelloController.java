package com.strannikov.javariga13ex.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String showHello(final ModelMap modelMap) {
        modelMap.addAttribute("userName","Deniss");
        return "welcome";
    }
}