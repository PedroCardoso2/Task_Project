package com.example.task.taskToday.domain.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Date;

public record DadosUsuarioCadastrar(
        @NotBlank
        Long id,

        @NotBlank
        @Column(name = "nome_Usu")
        String nome,

        @NotBlank
        @Column(name = "sobrenome_Usu")
        String sobreNome,
        @NotBlank
        String email,
        @NotBlank
        @Column(name = "data_Nascimento")
        String dataNascimento,
        @NotBlank
        String senha
) {
}
