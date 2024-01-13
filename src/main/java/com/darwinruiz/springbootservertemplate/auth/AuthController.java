package com.darwinruiz.springbootservertemplate.auth;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.darwinruiz.springbootservertemplate.auth.dtos.AuthResponseDto;
import com.darwinruiz.springbootservertemplate.auth.dtos.LoginUserDto;
import com.darwinruiz.springbootservertemplate.auth.users.dtos.CreateUserDto;
import com.darwinruiz.springbootservertemplate.configurations.exceptions.RequestException;
import com.darwinruiz.springbootservertemplate.security.services.AuthenticationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<AuthResponseDto> signup(@Valid @RequestBody CreateUserDto request,
            BindingResult bindingResult) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> signin(@Valid @RequestBody LoginUserDto request,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            List<String> messages = bindingResult.getFieldErrors().stream()
                    .map(record -> record.getField() + " - " + record.getDefaultMessage())
                    .collect(Collectors.toList());
            throw new RequestException(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.getReasonPhrase(), messages);
        }

        return ResponseEntity.ok(authenticationService.signin(request));
    }
}
