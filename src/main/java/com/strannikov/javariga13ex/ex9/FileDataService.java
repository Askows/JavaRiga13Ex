package com.strannikov.javariga13ex.ex9;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class FileDataService {

    private final FileDataRepo fileDataRepo;
    public List<FileData> getAll() {
        return fileDataRepo.findAll();
    }
}
