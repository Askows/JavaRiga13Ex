package com.strannikov.javariga13ex.thymeleaf;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequiredArgsConstructor
@SessionAttributes("errors")
@RequestMapping("/pet")

public class PetController {

    private final PetRepository petRepository;

    @GetMapping
    public String showHomePage(final ModelMap modelMap) {
        String name =  SecurityContextHolder.getContext().getAuthentication().getName();
        modelMap.addAttribute("userLoginName",name);
        modelMap.addAttribute("userName","Andrew");
        modelMap.addAttribute("newPet",new Pet());
        return "welcome";
    }


    @PostMapping("/save")
    public String savePet(final ModelMap modelMap, @Valid Pet pet, Errors errors) {
        if (errors.hasErrors()) {
            modelMap.addAttribute(
                    "errors",
                    errors.getAllErrors().stream()
                            .map(error -> error.getDefaultMessage())
                            .collect(Collectors.toList()));
        } else {
            petRepository.save(pet);
        }
        return "redirect:/pet";
    }

    @GetMapping("/all")
    public String showAllPets(final ModelMap modelMap){
        modelMap.addAttribute("petList",petRepository.findAll());
        return "pet-list";
    }

}