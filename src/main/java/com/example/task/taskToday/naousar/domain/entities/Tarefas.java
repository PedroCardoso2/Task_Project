package com.example.task.taskToday.naousar.domain.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

//@Entity
//@Table
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//public class Tarefas {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "Id_Tarefas")
//    private Long idTar;
//
//    @Column(name = "nome_Taref")
//    @Size(max = 100)
//    private String descTar;
//
//    @Column(name = "feito")
//    private Enum statusTar;
//    @Column(name = "data_inicio_taref")
//    private Date inicTar;
//    @Column(name = "data_final_taref")
//    private Date FinTarf;
//
//
//    @Column(name = "Id_Usu")
//    private Usuario usuario;
//
//}
