package com.example.task.taskToday.domain.dtos;

import com.example.task.taskToday.domain.entities.Usuario;

import java.sql.Date;
import java.util.Optional;

public record DadosUsuarioSelecionado(Long Id, String nome, String email, Date dataNascimento) {

    public DadosUsuarioSelecionado(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getDataNascimento());
    }

}
