    package com.example.task.taskToday.controller;


    import com.example.task.taskToday.domain.UsuarioRepository;

    import com.example.task.taskToday.domain.dtos.DadosAtualizacaoUsuario;
    import com.example.task.taskToday.domain.dtos.DadosUsuarioCadastrar;
    import com.example.task.taskToday.domain.dtos.DetalhamentoUsuarios;
    import com.example.task.taskToday.domain.service.UsuarioService;
    import jakarta.validation.Valid;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.data.domain.Page;
    import org.springframework.data.domain.Pageable;
    import org.springframework.data.web.PageableDefault;
    import org.springframework.http.ResponseEntity;
    import org.springframework.transaction.annotation.Transactional;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.util.UriComponentsBuilder;

    @RestController
    @RequestMapping("/usuario")
    public class UsuarioController {

        @Autowired
        private UsuarioRepository db;

        @Autowired
        private UsuarioService service;


        // Trazer Usuários (Código 200)
        @GetMapping
        public ResponseEntity<Page<DetalhamentoUsuarios>> getUser(@PageableDefault Pageable pageable) {
            return service.buscarTodos(pageable);
        }

        @GetMapping("/{Id}")
        public ResponseEntity getOnlyUser(@PathVariable Long Id){
            return service.buscaUnica(Id);
        }



        // Cadastrar (Código 201)
        @PostMapping
        @Transactional
        public ResponseEntity postUser(@RequestBody @Valid DadosUsuarioCadastrar usu, UriComponentsBuilder uriComponentsBuilder) {
            return service.inserirUsuario(usu, uriComponentsBuilder);
        }


        // Atualizar (Código 200)
        @PutMapping
        @Transactional
        public ResponseEntity putUser(@RequestBody @Valid DadosAtualizacaoUsuario usu) {
            return service.atualizarUsuario(usu);
        }

        @DeleteMapping("/del/{Id}")
        @Transactional
        public ResponseEntity deleteUser(@PathVariable Long Id){
            return service.deleteUser(Id);
        }


    }
