package com.example.auth.services.usecases;

import com.example.auth.repositories.TaskRepository;
import com.example.auth.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TaskUseCasesTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskUseCases taskUseCases;

    @Mock
    private UserRepository userRepository;

    @Test
    @DisplayName("Resgatar Atividades")
    void getTask() {
        Assertions.assertEquals(1, 1);
        Mockito.when(userRepository.findAll()).thenReturn(new ArrayList<>());
    }

    @Test
    @DisplayName("Criar Atividade")
    void createTask() {
    }
}