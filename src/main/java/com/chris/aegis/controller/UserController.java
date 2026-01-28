package com.chris.aegis.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class UserController {
    public final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
