package com.example.auth.controllers;

import com.example.auth.domain.dtos.AuthenticationDTO;
import com.example.auth.domain.dtos.ResponseTokenDTO;
import com.example.auth.domain.dtos.RegisterDTO;
import com.example.auth.domain.user.User;
import com.example.auth.infra.security.TokenService;
import com.example.auth.repositories.UserRepository;
import com.example.auth.services.BuilderUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository repository;
    @Autowired
    private TokenService tokenService;

    @Autowired
    private BuilderUser builderUser;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        UserDetails userDetails = (UserDetails) auth.getPrincipal();

        var token = tokenService.generateToken(builderUser.getUser(userDetails));
        return ResponseEntity.ok(new ResponseTokenDTO(token));
    }


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();
        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.role());
        repository.save(newUser);
        return ResponseEntity.ok().body(new ResponseTokenDTO(encryptedPassword));
    }
}
