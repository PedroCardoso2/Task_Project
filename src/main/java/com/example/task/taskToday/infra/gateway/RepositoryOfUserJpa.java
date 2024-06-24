package com.example.task.taskToday.infra.gateway;

import com.example.task.taskToday.application.gateway.RepositoryUsuario;
import com.example.task.taskToday.domain.Usuario;
import com.example.task.taskToday.infra.persistence.UsuarioEntity;
import com.example.task.taskToday.infra.persistence.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RepositoryOfUserJpa implements RepositoryUsuario {

    private final UsuarioEntityMapper mapper;
    private final UsuarioRepository repository;

    public RepositoryOfUserJpa(UsuarioEntityMapper mapper, UsuarioRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public Usuario createUser(Usuario usuario) {
        if(repository.findByEmail(usuario.getEmail()) != null) throw new RuntimeException("Usuario Existente");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        String encrypt = encoder.encode(usuario.getSenha());
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario.getNome(), encrypt, usuario.getEmail(), usuario.getDateTime());
        repository.save(usuarioEntity);
        return mapper.toDomain(usuarioEntity);
    }

}
