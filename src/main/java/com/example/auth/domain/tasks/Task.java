package com.example.auth.domain.tasks;

import com.example.auth.domain.user.User;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private User user;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    private LocalDate dateTask;

    public Task(String description, User id_usuario, TaskStatus taskStatus) {
        this.description = description;
        this.user = id_usuario;
        this.taskStatus = taskStatus;
        this.dateTask = LocalDate.now();
    }

    public User getUserId() {
        return user;
    }

    public void setUserId(User userId) {
        this.user = userId;
    }

    public LocalDate getDateTask() {
        return dateTask;
    }

    public void setDateTask(LocalDate dateTask) {
        this.dateTask = dateTask;
    }

    public Task() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }
}
