package Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "Task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
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

    public Task(){}
}
