package com.strannikov.javariga13ex.ex9;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileDataService {

    private final FileDataRepo fileDataRepo;

    public List<FileData> getAll() {
        return fileDataRepo.findAll();
    }

    public FileData getById(final UUID id) {
        return fileDataRepo.findById(id)
                .orElseThrow(() -> new SdaException("File data with id:" + id + " not found!"));
    }

    public FileData save(FileData fileData) {
        return fileDataRepo.save(fileData);
    }

    public void update(UUID id, FileData fileData) {
        FileData fileDataFromDB = getById(id);
        fileData.setId(fileDataFromDB.getId());
        fileDataRepo.save(fileData);
    }

    public void delete(UUID id) {
        FileData fileDataFromDB = getById(id);
        fileDataRepo.delete(fileDataFromDB);
    }
}
