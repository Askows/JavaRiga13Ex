package com.strannikov.javariga13ex.ex9;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

import static com.strannikov.javariga13ex.ex9.FileDataRestController.FILE_DATA_CONTROLLER_PATH;


@RestController
@RequiredArgsConstructor
@RequestMapping(FILE_DATA_CONTROLLER_PATH)
public class FileDataRestController {

    public static final String FILE_DATA_CONTROLLER_PATH = "/api/files-data";

    private final FileDataService fileDataService;

    @GetMapping
    public FileDataWrapper getAll() {
        return new FileDataWrapper(fileDataService.getAll());
    }

    @GetMapping("/{id}")
    public FileData getById(@PathVariable("id") UUID id) {
        return fileDataService.getById(id);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody FileData fileData) {
        FileData savedFileData = fileDataService.save(fileData);
        return ResponseEntity
                .created(URI.create("localhost:8080" + FILE_DATA_CONTROLLER_PATH + "/" + fileData.getId()))
                .body(savedFileData);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(
            @PathVariable("id") UUID id,
            @RequestBody FileData fileData) {
        fileDataService.update(id, fileData);
        return ResponseEntity.status(204).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(
            @PathVariable("id") UUID id) {
        fileDataService.delete(id);
        return ResponseEntity.status(204).build();
    }
}
