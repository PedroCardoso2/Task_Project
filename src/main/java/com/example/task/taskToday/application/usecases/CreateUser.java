package com.example.task.taskToday.application.usecases;

import com.example.task.taskToday.application.gateway.RepositoryUsuario;
import com.example.task.taskToday.domain.Usuario;

public class CreateUser {
    private final RepositoryUsuario repository;

    public CreateUser(RepositoryUsuario usuario) {
        this.repository = usuario;
    }

    public Usuario create(Usuario usuario){
        return this.repository.createUser(usuario);
    }

}
