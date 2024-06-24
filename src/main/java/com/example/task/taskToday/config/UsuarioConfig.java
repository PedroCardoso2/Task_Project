package com.example.task.taskToday.config;

import com.example.task.taskToday.application.gateway.RepositoryUsuario;
import com.example.task.taskToday.application.usecases.CreateUser;
import com.example.task.taskToday.infra.gateway.RepositoryOfUserJpa;
import com.example.task.taskToday.infra.gateway.UsuarioEntityMapper;
import com.example.task.taskToday.infra.persistence.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {
    @Bean
    CreateUser createUser(RepositoryUsuario repo){
        return new CreateUser(repo);
    }

    @Bean
    RepositoryOfUserJpa repositoryOfUserJpa(UsuarioEntityMapper mapper, UsuarioRepository repository){
        return new RepositoryOfUserJpa(mapper, repository);
    }

    @Bean
    UsuarioEntityMapper usuarioEntityMapper(){
        return new UsuarioEntityMapper();
    }

}
