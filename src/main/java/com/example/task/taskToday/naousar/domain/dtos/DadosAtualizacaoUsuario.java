package com.example.task.taskToday.naousar.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public record DadosAtualizacaoUsuario(
        @NotNull
        Long Id,

        @NotNull
        String nome,

        @NotNull
        String email,

        Date dataNascimento,
        @NotNull
        String senha

) {
}
