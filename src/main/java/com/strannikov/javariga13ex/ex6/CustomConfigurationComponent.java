package com.strannikov.javariga13ex.ex6;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "pl.sdacademy.zad6")
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Validated
public class CustomConfigurationComponent {

    @NotNull(message = "email cannot be null")
    @Email(message = "incorrect email format")
    private String email;

    private String firstName;

    @NotNull(message = "age is mandatory")
    @Min(value = 18)
    private Integer age;

    @NotNull(message = "last name has to be provided")
    @Length(min = 3, max = 20)
    private String lastName;

    private String address;

    @NotEmpty(message = "values cannot be empty")
    private List<String> values;

    @NotEmpty(message = "custom attributes cannot be empty")
    private Map<String, String> customAttributes;

    @AssertTrue(message = "address is invalid")
    public boolean isAddressValid() {
        return address != null && address.split(" ").length == 2;
    }
}
