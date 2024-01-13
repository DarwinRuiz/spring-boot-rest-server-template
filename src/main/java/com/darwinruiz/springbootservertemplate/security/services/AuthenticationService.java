package com.darwinruiz.springbootservertemplate.security.services;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.darwinruiz.springbootservertemplate.auth.dtos.AuthResponseDto;
import com.darwinruiz.springbootservertemplate.auth.dtos.LoginUserDto;
import com.darwinruiz.springbootservertemplate.auth.users.dtos.CreateUserDto;
import com.darwinruiz.springbootservertemplate.auth.users.dtos.UserResponseLoginDto;
import com.darwinruiz.springbootservertemplate.auth.users.models.UserModel;
import com.darwinruiz.springbootservertemplate.auth.users.repositories.UserRepository;
import com.darwinruiz.springbootservertemplate.security.jwt.JwtUtils;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthResponseDto signup(CreateUserDto userData) {
        UserModel user = UserModel.builder()
                .username(userData.getUsername())
                .password(passwordEncoder.encode(userData.getPassword()))
                .name(userData.getName())
                .email(userData.getEmail())
                .avatar(userData.getAvatar())
                .status(true).build();

        return this.generateAuthResponseDto(userRepository.save(user));

    }

    public AuthResponseDto signin(LoginUserDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserModel user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Invalid username or password."));

        return this.generateAuthResponseDto(userRepository.save(user));
    }

    private AuthResponseDto generateAuthResponseDto(UserModel user) {
        String jwtToken = jwtUtils.generateToken(user);

        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();

        Set<String> roles = authorities.stream().map(authority -> authority.getAuthority()).collect(Collectors.toSet());

        UserResponseLoginDto userResponseData = UserResponseLoginDto.builder()
                .name(user.getName())
                .id(user.getUserId())
                .email(user.getEmail())
                .isActive(user.getStatus())
                .roles(roles).build();

        AuthResponseDto response = AuthResponseDto.builder().user(userResponseData).token(jwtToken).build();

        return response;
    }
}
