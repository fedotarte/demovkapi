package com.example.demovkapi.controllers;

import com.example.demovkapi.exceptions.VKBadResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceotionHandler {

    @ExceptionHandler({VKBadResponseException.class, RuntimeException.class})
    public ResponseEntity<?> handleVKException(RuntimeException e) {
        return ResponseEntity.status(418).header("XerrorMsg", e.getMessage()).build();
    }
}
