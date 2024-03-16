package com.example.task.taskToday.domain.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.sql.Date;


@Entity
@Table(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Usuario {

    @Column(name = "Id_Usu")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "nome_Usu")
    @NotBlank
    @Size(min = 2, max = 50)
    private String nome;

    @Column(name = "sobrenome_Usu")
    @NotBlank
    @Size(min = 2, max = 50)
    private String sobreNome;

    @NotBlank
    private String senha;


    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @Column(name = "data_Nascimento")
    @NotBlank
    private Date dataNascimento;

}
