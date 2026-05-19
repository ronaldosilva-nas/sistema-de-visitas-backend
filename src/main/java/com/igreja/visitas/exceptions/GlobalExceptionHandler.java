package com.igreja.visitas.exceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MembroNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleMembroNotFound(MembroNotFoundException ex) {

        ErrorResponse erro = new ErrorResponse(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, List<String>> handleValidationErrors(MethodArgumentNotValidException ex) {

        //método 1 para retornar um erro com JSON com campos
        /*List<String> erros = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(e -> e.getDefaultMessage())
            .toList();

        return Map.of("erros", erros);*/   
        
        //método com múltiplos erros por campo
        Map<String, List<String>> erros = new HashMap<>();
        
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            String campo = error.getField();
            String mensagem = error.getDefaultMessage();

            erros.computeIfAbsent(campo, k -> new ArrayList<>()).add(mensagem);
        });

        return erros;
    }

    //outra forma de retornar uma mensagem de erro em JSON
    /*@ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationErrors(
            MethodArgumentNotValidException ex) {

        Map<String, String> erros = new HashMap<>();

        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error -> {

                    String campo = error.getField();
                    String mensagem = error.getDefaultMessage();

                    erros.put(campo, mensagem);
                });

        return erros;
    }*/
}
