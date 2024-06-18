package com.example.task.taskToday.config;

import com.example.task.taskToday.application.gateway.RepositoryUsuario;
import com.example.task.taskToday.application.usecases.CreateUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {
    @Bean
    CreateUser createUser(RepositoryUsuario repo){
        return new CreateUser(repo);
    }

}
