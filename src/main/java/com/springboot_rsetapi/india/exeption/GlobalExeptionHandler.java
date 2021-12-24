package com.springboot_rsetapi.india.exeption;

import java.util.Date;

import org.hibernate.jdbc.Expectation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExeptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundExeption(
            ResourceNotFoundException exeption, WebRequest request) {

        ErrorDetails errorDetails = 
        new ErrorDetails(new Date(), exeption.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGlobalExeption(
            Exception exeption, WebRequest request) {

        ErrorDetails errorDetails = 
        new ErrorDetails(new Date(), exeption.getMessage(), request.getDescription(false));
        
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> customValidationErrorHandling(
            MethodArgumentNotValidException exeption, WebRequest request) {

        ErrorDetails errorDetails = 
        new ErrorDetails(new Date(), "Validation error", 
                            exeption.getBindingResult().getFieldError().getDefaultMessage());
        
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

}
