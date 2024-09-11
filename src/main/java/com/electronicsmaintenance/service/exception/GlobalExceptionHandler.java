package com.electronicsmaintenance.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.springframework.http.converter.HttpMessageNotReadableException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Error 400
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        CustomErrorResponse customErrorResponse = new CustomErrorResponse("Resource not found",
                "Serviço não encontrado ou inexistente.", HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(customErrorResponse, HttpStatus.NOT_FOUND);
    }

    // Error 404
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<CustomErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        CustomErrorResponse customErrorResponse = new CustomErrorResponse("Poorly formatted request",
                "Requisição com corpo mal formatado ou inválido.", HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(customErrorResponse, HttpStatus.BAD_REQUEST);
    }

    // Error 500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrorResponse> handleGenericException(Exception ex) {
        CustomErrorResponse customErrorResponse = new CustomErrorResponse("Internal server error",
                "Erro interno do servidor.", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(customErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
