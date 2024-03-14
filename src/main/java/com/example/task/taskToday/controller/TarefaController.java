package com.example.task.taskToday.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TarefaController {

    @GetMapping
    public String iniciadoProjeto(){
        return "Iniciado";
    }

}
