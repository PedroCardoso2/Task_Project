package com.example.task.taskToday.infra.gateway;

import com.example.task.taskToday.domain.Usuario;
import com.example.task.taskToday.infra.persistence.UsuarioEntity;

public class UsuarioEntityMapper {

    public UsuarioEntity toEntity(Usuario usuario){
        return new UsuarioEntity(usuario.getNome(), usuario.getSenha(), usuario.getEmail(), usuario.getDateTime());
    }

    public Usuario toDomain(UsuarioEntity usuario){
        return new Usuario(usuario.getNome(), usuario.getEmail(), usuario.getDataNascimento(), usuario.getSenha());
    }

}
