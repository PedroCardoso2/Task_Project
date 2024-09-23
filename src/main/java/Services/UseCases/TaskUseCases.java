package Services.UseCases;


import Entities.Task;
import Entities.Usuario;
import Services.Db.TaskRepository;
import Services.Db.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class TaskUseCases implements TaskFactory{

    @Autowired
    private  TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<Task> getTask(String email) {
        Usuario user = userRepository.findByEmail(email);
        if(user == null) throw new RuntimeException("User não encontrado");
        List<Task> taskList = taskRepository.findByUsuario(user);
        taskList.stream().forEach(task -> {
           if(task.getDateTask() != LocalDate.now()){taskRepository.deleteById(task.getId());}
        });

        return taskList;
    }

    @Override
    public Task createTask(String email, String description) {
        Usuario usuario = userRepository.findByEmail(email);
        if (usuario == null) throw new RuntimeException("Usuario não existe");
        Task task = new Task(usuario, description);
        return taskRepository.save(task);
    }

}
