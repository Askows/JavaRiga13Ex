package com.strannikov.javariga13ex.ex9;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/files-data")
@RequiredArgsConstructor
public class FileDataRestController {

    private final FileDataService fileDataService;

    @GetMapping
    public FileDataWrapper getAll(){
        return  new FileDataWrapper(fileDataService.getAll());
    }

}
