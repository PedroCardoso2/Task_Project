package Controller;

import Dto.DtoRegister;
import Entities.Usuario;
import Services.Db.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody DtoRegister dados){
        Usuario usuario = new Usuario(dados.name(), dados.email(), dados.password(),dados.dataNascimento());
        userRepository.save(usuario);
        return ResponseEntity.ok().body(usuario);
    }


}
