package com.example.auth.domain.dtos;

import com.example.auth.domain.user.UserRole;

public record RegisterDTO(String name, String login, String password, UserRole role) {}
