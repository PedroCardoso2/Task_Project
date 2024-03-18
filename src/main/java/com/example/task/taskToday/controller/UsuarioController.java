package com.example.task.taskToday.controller;


import com.example.task.taskToday.domain.UsuarioRepository;

import com.example.task.taskToday.domain.dtos.DadosAtualizacaoUsuario;
import com.example.task.taskToday.domain.dtos.DadosUsuarioCadastrar;
import com.example.task.taskToday.domain.dtos.DadosUsuarioSelecionado;
import com.example.task.taskToday.domain.entities.Usuario;
import com.example.task.taskToday.domain.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository db;

    @Autowired
    private UsuarioService service;


    // Trazer Usuários (Código 200)
    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable Long Id){
        return service.buscar(Id);
    }


    // Cadastrar (Código 201)
    @PostMapping
    public ResponseEntity postUser(@RequestBody @Valid DadosUsuarioCadastrar usu, UriComponentsBuilder uriComponentsBuilder){
        return service.inserirUsuario(usu, uriComponentsBuilder);
    }



    // Atualizar (Código 200)
    @PutMapping
    public ResponseEntity putUser(@RequestBody @Valid DadosAtualizacaoUsuario usu){
        var usuario = db.getReferenceById(usu.id());

        usuario.atualizarDados(usu);

        return ResponseEntity.ok(new DadosUsuarioSelecionado(usuario));

    }


}
