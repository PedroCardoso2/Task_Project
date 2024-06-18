package com.example.task.taskToday.naousar.domain.dtos;

import com.example.task.taskToday.naousar.domain.entities.Usuario;

import java.sql.Date;

public record DadosUsuarioSelecionado(Long Id, String nome, String email, Date dataNascimento) {

    public DadosUsuarioSelecionado(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getDataNascimento());
    }

}
