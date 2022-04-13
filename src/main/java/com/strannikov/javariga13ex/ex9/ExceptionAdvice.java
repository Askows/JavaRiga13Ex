package com.strannikov.javariga13ex.ex9;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity handleArgumentExceptiuon(MethodArgumentTypeMismatchException ex){
        return ResponseEntity.badRequest().
                body(ex.getMessage());
    }



}
