package com.strannikov.javariga13ex.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity handleBindingErrors(MethodArgumentNotValidException exception) {
        return ResponseEntity.
                badRequest()
                .body(exception.getAllErrors()
                        .stream()
                        .map(e -> e.getDefaultMessage())
                        .collect(Collectors.toList()));
    }


    @ExceptionHandler({NameException.class})
    public ResponseEntity handleBindingErrors(NameException exception) {
        return ResponseEntity.badRequest()
                .body(exception.getMessage());
    }

}
