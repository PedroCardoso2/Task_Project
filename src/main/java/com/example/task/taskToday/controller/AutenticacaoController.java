    package com.example.task.taskToday.controller;

    import com.example.task.taskToday.domain.dtos.DadosAutenticacao;
    import com.example.task.taskToday.domain.dtos.DadosUsuarioSelecionado;
    import com.example.task.taskToday.domain.entities.Usuario;
    //import com.example.task.taskToday.infra.security.TokenService;
    import com.example.task.taskToday.infra.security.DadosTokenJWT;
    import com.example.task.taskToday.infra.security.TokenService;
    import jakarta.validation.Valid;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.security.authentication.AuthenticationManager;
    import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/login")
    public class AutenticacaoController {

        @Autowired
        private AuthenticationManager manager;


        @PostMapping
        public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
           var userAuthetication = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
           var auth = this.manager.authenticate(userAuthetication);


           return ResponseEntity.ok().build();
        }

    }
