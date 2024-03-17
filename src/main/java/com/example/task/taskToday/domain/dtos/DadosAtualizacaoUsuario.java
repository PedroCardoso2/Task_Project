package com.example.task.taskToday.domain.dtos;

import jakarta.validation.constraints.NotBlank;

import java.sql.Date;

public record DadosAtualizacaoUsuario(
        @NotBlank
        Long id,


        String name,


        String sobreNome,

        String email,

        String dataNascimento,

        String senha

) {
}
