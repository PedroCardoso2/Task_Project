package com.example.task.taskToday.infra.controller;

import com.example.task.taskToday.application.usecases.CreateUser;
import com.example.task.taskToday.domain.Usuario;
import com.example.task.taskToday.infra.persistence.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UsuarioController {
    private final CreateUser createUser;
    private final AuthenticationManager manager;
    private final TokenService token;

    public UsuarioController(CreateUser createUser, AuthenticationManager manager, TokenService token) {
        this.createUser = createUser;
        this.manager = manager;
        this.token = token;
    }

    @PostMapping("/send-date")
    public ResponseEntity<DadosUsuarioCadastrar> cadastrarUsuario(@RequestBody @Valid DadosUsuarioCadastrar dados){
        var user = createUser.create(new Usuario(dados.nome(), dados.email(), dados.dataNascimento(), dados.senha()));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new DadosUsuarioCadastrar(user.getNome(), user.getEmail(), user.getDateTime(), user.getSenha()));
    }


}
