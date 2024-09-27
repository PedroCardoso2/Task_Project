package com.example.auth.domain.dtos;

import com.example.auth.domain.user.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
