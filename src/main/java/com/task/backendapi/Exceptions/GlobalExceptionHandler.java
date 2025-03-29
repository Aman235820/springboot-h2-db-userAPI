package com.task.backendapi.Exceptions;


import com.task.backendapi.Models.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseDTO> resourceNotFoundException(ResourceNotFoundException ce) {
        return new ResponseEntity<>(new ResponseDTO(null, ce.getMessage(), true), HttpStatus.NOT_FOUND);
    }

}
