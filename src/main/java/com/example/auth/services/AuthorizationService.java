package com.example.auth.services;

import com.example.auth.domain.user.User;
import com.example.auth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = repository.findByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return user;
    }
}
