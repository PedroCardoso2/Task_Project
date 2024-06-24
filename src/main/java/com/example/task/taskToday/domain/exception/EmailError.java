package com.example.task.taskToday.domain.exception;

public class EmailError extends IllegalArgumentException {
    public EmailError(String msg) {
        super(msg);
    }
}
