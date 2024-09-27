package com.example.auth.repositories;

import com.example.auth.domain.tasks.Task;
import com.example.auth.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByUser(User usuario);
}
