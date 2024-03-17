package com.example.task.taskToday.domain.dtos;

import com.example.task.taskToday.domain.entities.Usuario;

import java.sql.Date;

public record DadosUsuarioSelecionado(Long Id, String name, String email, String dataNascimento) {

    public DadosUsuarioSelecionado(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getDataNascimento());
    }

}
