package com.example.task.taskToday.naousar.domain.dtos.TarefasDtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DadosTarefaCadastro(
        @NotNull
        @JsonAlias({"id_Tarefa", "pk_Tarefa"})
        Integer id_Tarefa,

        @NotNull
        @JsonAlias({"id_Usuario", "pkUsu"})
        Integer id_Usu,

        @NotBlank
        String nome_tarefa,

        @NotNull
        @JsonAlias({"status", "cr_status"})
        char status,

        Date data_Inicio
) {
}
