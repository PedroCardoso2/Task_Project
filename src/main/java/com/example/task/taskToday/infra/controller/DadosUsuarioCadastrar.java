package com.example.task.taskToday.infra.controller;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;
import java.time.LocalDateTime;

public record DadosUsuarioCadastrar(

        @NotBlank
        String nome,


        @NotBlank
        String email,

        @NotBlank
        LocalDateTime dataNascimento,

        @NotBlank
        String senha
) {

}
