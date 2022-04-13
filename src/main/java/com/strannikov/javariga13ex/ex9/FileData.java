package com.strannikov.javariga13ex.ex9;


import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "FileData")
@Data
public class FileData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String fileName;
    private String extension;
    private long sizeInKb;
    private String content;

}

