package Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private LocalDate dataNascimento;

    public Usuario(String nome, String email, String senha, LocalDate dataNascimento) {
        if(nome == null || nome.isEmpty() || email == null || email.isEmpty()
        || senha == null || senha.isEmpty() || dataNascimento == null || dataNascimento.isAfter(LocalDate.now())) {
            throw new RuntimeException("Valores incompatíveis");
        }
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
    }
}
