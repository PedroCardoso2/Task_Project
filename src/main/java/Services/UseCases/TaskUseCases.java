package Services.UseCases;


import Entities.Task;
import Services.Db.TaskRepository;
import Services.Db.UserRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskUseCases implements TaskFactory{
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;


    public TaskUseCases(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Task> getTask(int ident, String email) {
        if(userRepository.findByEmail(email) == null) throw new RuntimeException("User não encontrado");
        List<Task> taskList = taskRepository.findByUsuarioId(ident);
        taskList.stream().forEach(task -> {
           if(task.getDateTask() != LocalDate.now()){taskRepository.deleteById(task.getId());}
        });

        return taskList;
    }

}
