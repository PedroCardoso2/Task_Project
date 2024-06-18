package com.example.task.taskToday.naousar.domain;

import com.example.task.taskToday.naousar.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    UserDetails findByLogin(String login);
}
