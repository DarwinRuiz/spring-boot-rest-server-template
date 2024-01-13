package com.darwinruiz.springbootservertemplate.auth.users.dtos;

import java.util.Set;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto {

    @NotBlank
    private String username;

    @NotBlank
    @Length(min = 8)
    private String password;

    private String name;

    private String avatar;

    @Email
    @NotBlank
    private String email;

    private Set<String> roles;
}
