package com.example.task.taskToday.domain.dtos;

import com.example.task.taskToday.domain.entities.Usuario;

import java.sql.Date;

public record DetalhamentoUsuarios(Long Id, String nome, String email, Date dataNascimento) {
    public DetalhamentoUsuarios(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getDataNascimento());
    }
}
