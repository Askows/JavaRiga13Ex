package com.strannikov.javariga13ex.ex9;

import lombok.Builder;
import lombok.Data;


import java.util.List;

@Data
@Builder
public class FileDataWrapper {
    private List<FileData> fileData;
}
