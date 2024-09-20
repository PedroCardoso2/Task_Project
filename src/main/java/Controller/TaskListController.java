package Controller;


import Dto.DadosAdicionarAtividade;
import Entities.Task;
import Entities.Usuario;
import Services.Db.TaskRepository;
import Services.Db.UserRepository;
import Services.UseCases.TaskUseCases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/taks")
public class TaskListController {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskUseCases taskUseCases;

    @PostMapping("/add")
    public ResponseEntity<Task>  adicionarTask(@RequestBody DadosAdicionarAtividade dados){
        return ResponseEntity.status(HttpStatus.OK).body(taskUseCases.createTask(dados.email(), dados.desctask()));
    }

    @GetMapping
    public ResponseEntity<List<Task>> list(@RequestBody String email){
        return ResponseEntity.status(HttpStatus.OK).body(taskUseCases.getTask(email));
    }
}
