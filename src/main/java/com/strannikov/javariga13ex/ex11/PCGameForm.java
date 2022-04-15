package com.strannikov.javariga13ex.ex11;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PCGameForm {
    private String title;
    private String producer;
    private String genre;
    private Integer minimumAge;
    private Boolean isAAA;
}
