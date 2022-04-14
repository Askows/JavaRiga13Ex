package com.strannikov.javariga13ex.thymeleaf;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/pet")
public class PetController {

    private final PetRepository petRepository;

    @GetMapping
    public String showHomePage(final ModelMap modelMap) {
        modelMap.addAttribute("userName","Andrew");
        modelMap.addAttribute("newPet",new Pet());
        return "welcome";
    }

    @PostMapping("/save")
    public String savePet(Pet pet){
        petRepository.save(pet);
        return "redirect:/pet";
    }
    @GetMapping("/all")
    public String showAllPets(final ModelMap modelMap){
        modelMap.addAttribute("petList",petRepository.findAll());
        return "pet-list";
    }

}