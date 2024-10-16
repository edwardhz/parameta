package com.edward.SpringProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        String errorMessage = "Formato de fecha invalido. Por favor use el formato yyyy-MM-dd.";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("errorCode", "4003", "message", errorMessage));
    }
}
