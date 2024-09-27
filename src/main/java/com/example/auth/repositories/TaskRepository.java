package com.example.auth.repositories;

import com.example.auth.domain.tasks.Task;
import com.example.auth.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {


    List<Task> findByUser( User usuario);
}

