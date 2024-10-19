package com.example.auth.controllers;import com.example.auth.domain.dtos.DadosAdicionarAtividade;import com.example.auth.domain.tasks.Task;import com.example.auth.repositories.TaskRepository;import com.example.auth.repositories.UserRepository;import com.example.auth.services.usecases.TaskUseCases;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.http.HttpStatus;import org.springframework.http.ResponseEntity;import org.springframework.web.bind.annotation.*;import java.lang.reflect.Array;import java.util.Arrays;import java.util.List;@RestController@RequestMapping("/taks")@CrossOrigin(origins = "*")public class TaskController {    @Autowired    private TaskRepository taskRepository;    @Autowired    private UserRepository userRepository;    @Autowired    private TaskUseCases taskUseCases;    @PostMapping("/add")    public ResponseEntity<Task> addTask(@RequestBody DadosAdicionarAtividade dados){        return ResponseEntity.status(HttpStatus.OK).body(taskUseCases.createTask(dados.email(), dados.desctask()));    }    @PutMapping("/{id}")    public ResponseEntity<?> updateStatus(@PathVariable int id){        return ResponseEntity.status(HttpStatus.ACCEPTED).body(taskUseCases.updateTask(id));    }    @GetMapping("/{email}")    public ResponseEntity<List<Task>> list(@PathVariable String email) {        List<Task> tasks = taskUseCases.getTask(email);        return ResponseEntity.ok().body(tasks);    }    @DeleteMapping("/{id}")    public ResponseEntity<?> deleteTask(@PathVariable int id){        return ResponseEntity.status(HttpStatus.ACCEPTED).body(taskUseCases.deleteTask(id));    }}