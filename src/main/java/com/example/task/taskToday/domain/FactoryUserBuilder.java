package com.example.task.taskToday.domain;

import java.time.LocalDateTime;

public class FactoryUserBuilder {
    private Usuario usuario;

    public Usuario createUserAnyTips(String email, String senha, String nome, LocalDateTime dateTime){
        this.usuario = new Usuario(nome, "",dateTime, senha);
        return usuario;
    }

}
