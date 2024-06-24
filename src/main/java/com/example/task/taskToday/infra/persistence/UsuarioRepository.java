package com.example.task.taskToday.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;


public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{
    UserDetails findByEmail(String email);
}
