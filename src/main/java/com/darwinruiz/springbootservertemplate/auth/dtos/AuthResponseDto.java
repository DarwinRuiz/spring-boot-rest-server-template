package com.darwinruiz.springbootservertemplate.auth.dtos;

import com.darwinruiz.springbootservertemplate.auth.users.dtos.UserResponseLoginDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AuthResponseDto {
    private UserResponseLoginDto user;
    private String token;
}
