package com.example.task.taskToday.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {
    // Entidade não encontrada
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404(){
        //retorna 404
        return ResponseEntity.notFound().build();
    }
    //Me
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException ex){
        var erros = ex.getFieldError();

        return ResponseEntity.badRequest().body(erros);
    }


    private record DadosErroValidacão(){}



}
