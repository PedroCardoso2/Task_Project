package com.example.task.taskToday.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

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
       List<FieldError> erros = ex.getBindingResult().getFieldErrors();


        List<DadosErroValidacão> dadosErros = erros.stream().map(DadosErroValidacão::new).collect(Collectors.toList());

        return ResponseEntity.badRequest().body(dadosErros);
    }


    // Personalizar a lista com DTO
    private record DadosErroValidacão(String campo,String mensagem){
        public DadosErroValidacão(FieldError error){
            this(error.getField(), error.getDefaultMessage());
        }

    }



}
