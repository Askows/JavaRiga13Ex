package com.strannikov.javariga13ex.ex9;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@With
@AllArgsConstructor
@NoArgsConstructor
public class FileData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String fileName;
    private String extension;
    private long sizeInKb;
    private String content;



}

