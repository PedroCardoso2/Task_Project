package com.example.auth.services;

import com.example.auth.domain.user.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class BuilderUser {
    public UserDetails getUserDetails(User user) {
        return user;
    }

    public User getUser(UserDetails user) {
        if (!(user instanceof User)) throw new IllegalArgumentException("User is not a user");
        return (User) user;
     }
}
