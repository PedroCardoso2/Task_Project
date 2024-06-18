package com.example.task.taskToday.naousar.domain.service;

import com.example.task.taskToday.naousar.domain.UsuarioRepository;
import com.example.task.taskToday.naousar.domain.dtos.DadosAtualizacaoUsuario;
import com.example.task.taskToday.naousar.domain.dtos.DadosUsuarioSelecionado;
import com.example.task.taskToday.naousar.domain.dtos.DetalhamentoUsuarios;
import com.example.task.taskToday.naousar.domain.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;



    public ResponseEntity<Page<DetalhamentoUsuarios>> buscarTodos(Pageable pageable) {
        Page<Usuario> usuariosPage = repository.findAll(pageable);
        Page<DetalhamentoUsuarios> detalhamentoPage =
                usuariosPage.map(usuario -> new DetalhamentoUsuarios(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getDataNascimento()));
        return ResponseEntity.ok(detalhamentoPage);
    }

    public ResponseEntity buscaUnica(Long Id){
        var usuario = repository.getReferenceById(Id);

        return ResponseEntity.ok(new DadosUsuarioSelecionado(usuario));
    }


    public ResponseEntity atualizarUsuario(DadosAtualizacaoUsuario usu) {
        var usuario = repository.getReferenceById(usu.Id());

        usuario.atualizarDados(usu);

        return ResponseEntity.ok(new DadosUsuarioSelecionado(usuario));
    }

    public ResponseEntity deleteUser(Long Id) {
         var usu = repository.getReferenceById(Id);
         repository.deleteById(usu.getId());

        return ResponseEntity.ok(new DadosUsuarioSelecionado(usu));
    }
}
