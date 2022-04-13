package com.strannikov.javariga13ex.ex9;


import lombok.Data;
import lombok.With;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@With
public class FileData {
    @Id
    @GeneratedValue
    private UUID id;
    private String fileName;
    private String extension;
    private long sizeInKb;
    private String content;



}

