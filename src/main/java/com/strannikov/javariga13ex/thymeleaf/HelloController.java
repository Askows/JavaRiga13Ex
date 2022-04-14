package com.strannikov.javariga13ex.thymeleaf;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor

public class HelloController {

    private final PetRepository petRepository;

    @GetMapping("/hello")
    public String showHello(final ModelMap modelMap) {
        modelMap.addAttribute("userName","Andrew");
        modelMap.addAttribute("newPet",new Pet());
        return "welcome";
    }

    @PostMapping("/pet/save")
    public String savePet(Pet pet){
        petRepository.save(pet);
        return "redirect:/hello";
    }
}