package com.example.task.taskToday.naousar.domain.dtos;

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
        String email,

        @NotBlank
        @Column(name = "data_Nascimento")
        Date dataNascimento,

        @NotBlank
        String senha
) {
        // Construtor adicional para criar um novo DadosUsuarioCadastrar

}
