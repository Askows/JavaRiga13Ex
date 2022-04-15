package com.strannikov.javariga13ex.ex11;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/pc-game")
@Controller
public class PCGameController {

    @GetMapping
    public String getPcGameForm(final ModelMap modelMap){
        modelMap.addAttribute("createMessage", "Create PC Game");
        modelMap.addAttribute("pcGameForm", new PCGameForm());
        return "pcgame";
    }
}
