package com.example.task.taskToday.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public record DadosAtualizacaoUsuario(
        @NotNull
        Long Id,

        @NotNull
        String nome,


        String sobreNome,
        @NotNull
        String email,

        String dataNascimento,
        @NotNull
        String senha

) {
}
