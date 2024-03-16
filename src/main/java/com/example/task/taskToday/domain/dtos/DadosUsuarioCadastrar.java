package com.example.task.taskToday.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public record DadosUsuarioCadastrar(
        @NotBlank
        Long id,

        @NotBlank
        String name,

        @NotBlank
        String sobreNome,
        @NotBlank
        String email,
        @NotBlank
        Date dataNascimento,
        @NotBlank
        String senha
) {
}
