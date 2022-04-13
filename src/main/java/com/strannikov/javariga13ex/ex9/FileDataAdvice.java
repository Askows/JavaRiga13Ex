package com.strannikov.javariga13ex.ex9;

import com.strannikov.javariga13ex.rest.NameException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class FileDataAdvice {
    @ExceptionHandler({MethodArgumentTypeMismatchException.class, SdaException.class})
    public ResponseEntity handleSdaException(Exception ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

}
