package com.example.auth.services.usecases;

import com.example.auth.domain.tasks.Task;

import java.util.List;

public interface TaskFactory {
    List<Task> getTask(String email);
    Task createTask(String email, String description);
    Task updateTask(int id);
    Boolean deleteTask(int id);
}
