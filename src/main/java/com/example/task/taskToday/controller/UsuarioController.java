package com.example.task.taskToday.controller;


import com.example.task.taskToday.domain.UsuarioRepository;

import com.example.task.taskToday.domain.dtos.DadosUsuarioCadastrar;
import com.example.task.taskToday.domain.dtos.DadosUsuarioSelecionado;
import com.example.task.taskToday.domain.entities.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/us")
public class UsuarioController {

    @Autowired
    private UsuarioRepository db;


    // Trazer Usuários (Código 200)
    @GetMapping("/{id}")
    public ResponseEntity buscar(@PathVariable Long Id){
        var usuario = db.getReferenceById(Id);

        return ResponseEntity.ok(new DadosUsuarioSelecionado(usuario));
    }

    // Cadastrar (Código 204)
    @PostMapping
    public ResponseEntity inserirUsuario(@RequestBody @Valid DadosUsuarioCadastrar usu, UriComponentsBuilder uriComponentsBuilder){
        var usuario = new Usuario(usu);
        db.save(usuario);
        var uri = uriComponentsBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();

    }
}
