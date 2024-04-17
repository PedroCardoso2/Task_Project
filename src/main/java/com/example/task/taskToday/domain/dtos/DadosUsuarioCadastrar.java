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
        Date dataNascimento,

        @NotBlank
        String senha
) {
        // Construtor adicional para criar um novo DadosUsuarioCadastrar
        public DadosUsuarioCadastrar(
                String nome,
                String sobreNome,
                String email,
                Date dataNascimento,
                String senha
        ) {
                this(null, nome, sobreNome, email, dataNascimento, senha);
        }
}
