    package com.example.task.taskToday.controller;

    import com.example.task.taskToday.domain.UsuarioRepository;
    import com.example.task.taskToday.domain.dtos.DadosAutenticacao;
    import com.example.task.taskToday.domain.dtos.DadosUsuarioCadastrar;
    import com.example.task.taskToday.domain.dtos.ResponseDTO;
    import com.example.task.taskToday.domain.entities.Usuario;
    //import com.example.task.taskToday.infra.security.TokenService;
    import com.example.task.taskToday.infra.security.DadosTokenJWT;
    import com.example.task.taskToday.infra.security.TokenService;
    import jakarta.validation.Valid;
    import lombok.RequiredArgsConstructor;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.security.authentication.AuthenticationManager;
    import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;
    import org.springframework.web.util.UriComponentsBuilder;

    import java.util.Optional;

    @RestController
    @RequestMapping("/login")
    public class AutenticacaoController {

        @Autowired
        private AuthenticationManager manager;

        @Autowired
        private TokenService tokenService;

        @Autowired
        private UsuarioRepository repository;

        @PostMapping
        public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
            var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());

            var authentication = manager.authenticate(authenticationToken);

            var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

            if(tokenJWT == null){
                return ResponseEntity.ok("VAZIOO , SEM NADA ");
            }

            return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
        }

        @PostMapping("/rgs")
        public ResponseEntity registrarUsuario(@RequestBody @Valid DadosUsuarioCadastrar dados, UriComponentsBuilder uriComponentsBuilder) {
            if(repository.findByLogin(dados.nome()) != null) {
                return ResponseEntity.badRequest().body("Login já existe");
            }

            // Criptografar a senha
            String encryptedPassword = new BCryptPasswordEncoder().encode(dados.senha());

            // Criar um novo objeto DadosUsuarioCadastrar com a senha criptografada
            DadosUsuarioCadastrar dadosCriptografados = new DadosUsuarioCadastrar(
                    dados.id(),
                    dados.nome(),
                    dados.sobreNome(),
                    dados.email(),
                    dados.dataNascimento(),
                    encryptedPassword
            );

            // Salvar o novo usuário
            Usuario newUser = new Usuario(dadosCriptografados);
            repository.save(newUser);

            // Gerar token JWT para o novo usuário registrado
            String tokenJWT = tokenService.gerarToken(newUser);

            // Retornar o token JWT
            return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
        }

    }

