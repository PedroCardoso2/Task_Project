package Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToMany(mappedBy = "usuario")
    private List<Task> tasks;

    private String nome;
    private String email;
    private String senha;
    private LocalDate dataNascimento;
    private String role;

    public Usuario(String nome, String email, String senha, LocalDate dataNascimento, String role) {
        if(nome == null || nome.isEmpty() || email == null || email.isEmpty()
        || senha == null || senha.isEmpty() || dataNascimento == null || dataNascimento.isAfter(LocalDate.now()) || role.isEmpty()){
            throw new RuntimeException("Valores incompatíveis");
        }
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.role = role;
        this.dataNascimento = dataNascimento;
    }

    public Usuario() {}
}
