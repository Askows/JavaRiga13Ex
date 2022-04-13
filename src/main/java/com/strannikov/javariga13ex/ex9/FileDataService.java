package com.strannikov.javariga13ex.ex9;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileDataService {

    private final FileDataRepo fileDataRepo;


    public List<FileData> getAll() {
        return fileDataRepo.findAll();
    }



    public FileData getById(UUID uuid) {

        return fileDataRepo
                .findById(uuid).
                orElseThrow(()->
                new SdaException("File data with id "+ uuid+" not founded"));
    }
}
