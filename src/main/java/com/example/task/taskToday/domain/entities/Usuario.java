package com.example.task.taskToday.domain.entities;


import com.example.task.taskToday.domain.dtos.DadosAtualizacaoUsuario;
import com.example.task.taskToday.domain.dtos.DadosUsuarioCadastrar;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.sql.Date;


@Entity(name = "Usuario")
@Table(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario {

    @Column(name = "Id_Usu")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "nome_Usu")
    @NotNull
    @Size(max = 50)
    private String nome;

    @Column(name = "sobrenome_Usu")
    @NotNull
    @Size(max = 50)
    private String sobreNome;

    @NotBlank
    private String senha;


    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @Column(name = "data_Nascimento")
    @NotBlank
    private String dataNascimento;

    // Cadastro
    public Usuario(DadosUsuarioCadastrar usu) {
        this.nome = usu.nome();
        this.email = usu.email();
        this.senha = usu.senha();
        this.dataNascimento = usu.dataNascimento();
        this.sobreNome = usu.sobreNome();
    }

    // Atualização
    public void atualizarDados(DadosAtualizacaoUsuario usu) {
        this.nome = usu.name();
        this.email = usu.email();
        this.senha = usu.senha();
        this.dataNascimento = usu.dataNascimento();
        this.sobreNome = usu.sobreNome();
    }
}
