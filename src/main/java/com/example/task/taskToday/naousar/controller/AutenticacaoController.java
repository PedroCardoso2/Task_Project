    package com.example.task.taskToday.naousar.controller;

    import com.example.task.taskToday.naousar.domain.UsuarioRepository;
    import com.example.task.taskToday.naousar.domain.dtos.DadosAutenticacao;
    import com.example.task.taskToday.naousar.domain.dtos.DadosUsuarioCadastrar;
    import com.example.task.taskToday.naousar.domain.entities.Usuario;
    //import com.example.task.taskToday.infra.security.TokenService;
    import com.example.task.taskToday.naousar.infra.security.DadosTokenJWT;
    import com.example.task.taskToday.naousar.infra.security.TokenService;
    import jakarta.validation.Valid;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.security.authentication.AuthenticationManager;
    import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;
    import org.springframework.web.util.UriComponentsBuilder;

    @RestController
    @RequestMapping("/auth")
    public class AutenticacaoController {

        @Autowired
        private AuthenticationManager manager;

        @Autowired
        private TokenService tokenService;

        @Autowired
        private UsuarioRepository repository;

        @PostMapping("/login")
        public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
            var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());

            var authentication = manager.authenticate(authenticationToken);

            var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());

            return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
        }

        @PostMapping("/registro")
        public ResponseEntity registrarUsuario(@RequestBody @Valid DadosUsuarioCadastrar dados, UriComponentsBuilder uriComponentsBuilder) {
            if(repository.findByLogin(dados.nome()) != null) {
                return ResponseEntity.badRequest().body("Login já existe");
            }


            String encryptedPassword = new BCryptPasswordEncoder().encode(dados.senha());


            DadosUsuarioCadastrar dadosCriptografados = new DadosUsuarioCadastrar(
                    dados.id(),
                    dados.nome(),
                    dados.email(),
                    dados.dataNascimento(),
                    encryptedPassword
            );


            Usuario newUser = new Usuario(dadosCriptografados);
            repository.save(newUser);


            String tokenJWT = tokenService.gerarToken(newUser);

            return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
        }

    }

