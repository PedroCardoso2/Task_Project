package com.example.task.taskToday.domain.service;

import com.example.task.taskToday.domain.UsuarioRepository;
import com.example.task.taskToday.domain.dtos.DadosAtualizacaoUsuario;
import com.example.task.taskToday.domain.dtos.DadosUsuarioCadastrar;
import com.example.task.taskToday.domain.dtos.DadosUsuarioSelecionado;
import com.example.task.taskToday.domain.entities.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;


    public ResponseEntity buscar(Long Id) {
        var usuario = repository.getReferenceById(Id);

        return ResponseEntity.ok(new DadosUsuarioSelecionado(usuario));
    }


    public ResponseEntity inserirUsuario(DadosUsuarioCadastrar usu, UriComponentsBuilder uriComponentsBuilder) {
        var usuario = new Usuario(usu);
        repository.save(usuario);

        var uri = uriComponentsBuilder.path("/usu/table").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosUsuarioSelecionado(usuario));
    }

    public ResponseEntity atualizarUsuario(DadosAtualizacaoUsuario usu) {
        var usuario = repository.getReferenceById(usu.id());

        usuario.atualizarDados(usu);

        return ResponseEntity.ok(new DadosUsuarioSelecionado(usuario));

    }

}
