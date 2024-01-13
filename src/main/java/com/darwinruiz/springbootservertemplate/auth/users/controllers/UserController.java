package com.darwinruiz.springbootservertemplate.auth.users.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darwinruiz.springbootservertemplate.auth.users.dtos.CreateUserDto;
import com.darwinruiz.springbootservertemplate.auth.users.models.UserModel;
import com.darwinruiz.springbootservertemplate.auth.users.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserModel> create(@Valid @RequestBody CreateUserDto userData) {
        UserModel user = UserModel.builder()
                .username(userData.getUsername())
                .password(passwordEncoder.encode(userData.getPassword()))
                .name(userData.getName())
                .email(userData.getEmail())
                .avatar(userData.getAvatar()).build();

        this.userService.createRecord(user);

        return ResponseEntity.ok(user);
    }
}
