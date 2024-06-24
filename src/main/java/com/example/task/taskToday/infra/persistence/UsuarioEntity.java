    package com.example.task.taskToday.infra.persistence;


    import jakarta.persistence.*;
    import jakarta.validation.constraints.Email;
    import jakarta.validation.constraints.NotBlank;
    import jakarta.validation.constraints.NotNull;
    import jakarta.validation.constraints.Size;
    import lombok.*;
    import org.springframework.security.core.GrantedAuthority;
    import org.springframework.security.core.authority.SimpleGrantedAuthority;
    import org.springframework.security.core.userdetails.UserDetails;


    import java.time.LocalDateTime;
    import java.util.Collection;
    import java.util.List;


    @Entity(name = "usuario")
    @Table(name = "usuario")
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public class UsuarioEntity implements UserDetails {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "Id_Usu")
        private Long Id;

        @Column(name = "nome_Usu")
        @NotNull
        @Size(max = 50)
        private String nome;


        private String senha;

        @NotBlank
        @Size(max = 50)
        @Email
        private String email;

        @Column(name = "data_Nascimento")
        @NotNull
        private LocalDateTime dataNascimento;


        // Cadastro
        public UsuarioEntity(String nome, String senha, String email, LocalDateTime dataNascimento) {
            this.nome = nome;
            this.senha = senha;
            this.email = email;
            this.dataNascimento = dataNascimento;
        }


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
            return this.email;
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


        // Classes necessárias para identificação de login e senha



    }
