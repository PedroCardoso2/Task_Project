package com.example.task.taskToday.domain;

import com.example.task.taskToday.domain.exception.EmailError;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class FactoryUserBuilderTest {

    @Test
    public void testCriacaoUsuarioComEmailNull() {
        LocalDateTime dateTime = LocalDateTime.now();
        // Teste com e-mail inválido
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("Pedro Lucas", null , dateTime, "senha123");
        });
    }

    @Test
    public void testCriacaoUsuarioComEmailInvalido() {
        LocalDateTime dateTime = LocalDateTime.now();
        // Teste com e-mail inválido
        assertThrows(EmailError.class, () -> {
            new Usuario("Pedro Lucas", "pedro @gmail.com", dateTime, "124");
        });

        assertThrows(EmailError.class, () -> {
            new Usuario("Cardoso", "pedro @gmailcom", dateTime, "123");
        });

        assertThrows(EmailError.class, () -> {
            new Usuario("Lima", "pedrogmail.com", dateTime, "127");
        });

        assertThrows(EmailError.class, () -> {
            new Usuario("Vergan", "pedro @gmail .com", dateTime, "109");
        });

      
    }

    @Test
    public void testCriacaoUsuarioComSenhaNula() {
        LocalDateTime dateTime = LocalDateTime.now();

        // Teste com senha nula
        assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("Pedro Lucas", "pedro.lucas@gmail.com", dateTime, null);
        });
    }

}