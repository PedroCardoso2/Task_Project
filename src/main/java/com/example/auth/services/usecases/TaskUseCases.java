package com.example.auth.services.usecases;

import com.example.auth.domain.tasks.Task;
import com.example.auth.domain.tasks.TaskStatus;
import com.example.auth.domain.user.User;
import com.example.auth.repositories.TaskRepository;
import com.example.auth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class TaskUseCases implements TaskFactory {

    @Autowired
    private  TaskRepository taskRepository;

    @Autowired
    private  UserRepository userRepository;


    @Override
    public List<Task> getTask(String login) {
        User user = (User) userRepository.findByLogin(login);

        if (user == null) throw new RuntimeException("User não encontrado");
        List<Task> taskList = taskRepository.findByUser(user);
        taskList.removeIf(task -> !task.getDateTask().isEqual(LocalDate.now()));

        return taskList;
    }



    @Override
    public Task createTask(String login, String description) {
        User user = (User) userRepository.findByLogin(login);
        if (user == null) throw new RuntimeException("Usuario não existe");
        Task task = new Task(description, user , TaskStatus.PENDENTE);
        return taskRepository.save(task);
    }
}
