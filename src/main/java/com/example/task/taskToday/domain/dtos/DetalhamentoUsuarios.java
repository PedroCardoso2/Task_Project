package com.example.task.taskToday.domain.dtos;

import com.example.task.taskToday.domain.entities.Usuario;

public record DetalhamentoUsuarios(Long Id, String nome, String email, String dataNascimento) {
    public DetalhamentoUsuarios(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getDataNascimento());
    }
}
