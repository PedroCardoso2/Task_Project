package com.example.task.taskToday.domain;

import com.example.task.taskToday.domain.exception.EmailError;

import java.time.LocalDateTime;

public class Usuario {
    private Long id;
    private String nome;
    private String email;

    private LocalDateTime dateTime;

    private String senha;

    public Usuario(String nome, String email, LocalDateTime dateTime, String senha) {


        if(email == null || !email.matches("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$")) throw new EmailError("Email cadastrado Incorretamente");
        if(senha == null) throw new IllegalArgumentException("Senha Inválida");

        this.nome = nome;
        this.email = email;
        this.dateTime = dateTime;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }



    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
