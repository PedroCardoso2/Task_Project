package Controller;


import Dto.DadosAdicionarAtividade;
import Entities.Task;
import Entities.Usuario;
import Services.Db.TaskRepository;
import Services.Db.UserRepository;
import Services.UseCases.TaskUseCases;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Task adicionarTask(@RequestBody DadosAdicionarAtividade dados){
        Usuario usuario = userRepository.findByEmail(dados.email());
        if (usuario == null) throw new RuntimeException("Usuario não existe");
        Task task = new Task(usuario, dados.desctask());
        return taskRepository.save(task);
    }

    @GetMapping
    public List<Task> list(@RequestBody String email){
        return taskUseCases.getTask(email);
    }

    
}
