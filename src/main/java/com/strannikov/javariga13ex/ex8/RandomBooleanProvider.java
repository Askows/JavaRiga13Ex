package com.strannikov.javariga13ex.ex8;

import org.springframework.stereotype.Component;
import java.util.Random;

@Component
public class RandomBooleanProvider {
    private final boolean value = new Random().nextBoolean();

    public boolean getValue() {
        return value;
    }
}
