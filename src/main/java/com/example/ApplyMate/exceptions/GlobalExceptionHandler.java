package com.example.ApplyMate.exceptions;

import com.example.ApplyMate.dto.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomResponse<String>> resourceNotFound(ResourceNotFoundException e){

        return new ResponseEntity<>(
                new CustomResponse<>(
                        HttpStatus.NOT_FOUND,
                        e.getMessage(),
                        "Resource not Found Exception"
                ),
                HttpStatus.BAD_REQUEST
        );
    }

}