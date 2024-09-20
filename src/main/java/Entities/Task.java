package Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Getter
public class Task {
    private Usuario usuario;
    private String nameTask;
    private LocalDate dateTask;

    public Task(Usuario usuario, String nameTask) {
        if(usuario == null) throw new NullPointerException("Usuario null");
        if(nameTask == null) throw new NullPointerException("NameTask null");
        this.usuario = usuario;
        this.nameTask = nameTask;
        this.dateTask = LocalDate.now();
    }
}
