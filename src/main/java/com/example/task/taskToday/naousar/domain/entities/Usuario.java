    package com.example.task.taskToday.naousar.domain.entities;


    import com.example.task.taskToday.naousar.domain.dtos.DadosAtualizacaoUsuario;
    import com.example.task.taskToday.naousar.domain.dtos.DadosUsuarioCadastrar;
    import jakarta.persistence.*;
    import jakarta.validation.constraints.Email;
    import jakarta.validation.constraints.NotBlank;
    import jakarta.validation.constraints.NotNull;
    import jakarta.validation.constraints.Size;
    import lombok.*;
    import org.springframework.security.core.GrantedAuthority;
    import org.springframework.security.core.authority.SimpleGrantedAuthority;
    import org.springframework.security.core.userdetails.UserDetails;


    import java.sql.Date;
    import java.util.Collection;
    import java.util.List;


    @Entity(name = "usuario")
    @Table(name = "usuario")
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public class Usuario  implements UserDetails {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "Id_Usu")
        private Long Id;

        @Column(name = "nome_Usu")
        @NotNull
        @Size(max = 50)
        private String nome;


        private String login;


        private String senha;

        @NotBlank
        @Size(max = 50)
        @Email
        private String email;

        @Column(name = "data_Nascimento")
        @NotNull
        private Date dataNascimento;




        // Cadastro
        public Usuario(DadosUsuarioCadastrar usu) {
            this.nome = usu.nome();
            // Adicionado Login
            this.login = usu.email();
            this.email = usu.email();
            this.senha = usu.senha();
            this.dataNascimento = usu.dataNascimento();
        }

        // Atualização
        public void atualizarDados(DadosAtualizacaoUsuario usu) {
            if (usu.Id() != null) {
                this.Id = usu.Id();
            }
            if (usu.nome() != null) {
                this.nome = usu.nome();
            }

            if (usu.email() != null) {
                this.email = usu.email();
                this.login = usu.email();
            }
            if (usu.senha() != null) {
                this.senha = usu.senha();
            }
            if (usu.dataNascimento() != null) {
                this.dataNascimento = usu.dataNascimento();
            }

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


        // Classes necessárias para identificação de login e senha



    }
