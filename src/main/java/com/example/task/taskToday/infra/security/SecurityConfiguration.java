package com.example.task.taskToday.infra.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    // Objerto no spring relacionado a autent
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity  security) throws Exception{
        // Desativa o csrf -> MTD securança / E coloca na Session STATELLES
        return security.csrf(csrf -> csrf.disable())
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }
    @Bean
    // Essa classe foi preciso, por causa do Método do controller
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception{
        return configuration.getAuthenticationManager();
    }


    // Classe que reporesenta algoritimo de senha. hash seguro
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }


}
