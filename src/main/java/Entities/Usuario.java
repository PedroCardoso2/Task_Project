package Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Usuario")
public class Usuario implements UserDetails {

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
    private String login;

    public Usuario(String nome, String email, String senha, LocalDate dataNascimento) {
        if(nome == null || nome.isEmpty() || email == null || email.isEmpty()
        || senha == null || senha.isEmpty() || dataNascimento == null || dataNascimento.isAfter(LocalDate.now()) || role.isEmpty()){
            throw new RuntimeException("Valores incompatíveis");
        }
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.role = "USER";
        this.login = nome;
        this.dataNascimento = dataNascimento;
    }

    public Usuario() {}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
