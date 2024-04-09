package com.example.task.taskToday.domain;

import com.example.task.taskToday.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

//    UserDetails findByNome(String nome_Usu);
}
