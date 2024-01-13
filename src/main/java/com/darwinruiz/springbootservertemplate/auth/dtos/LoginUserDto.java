package com.darwinruiz.springbootservertemplate.auth.dtos;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserDto {
    @NotBlank
    private String username;

    @NotBlank
    @Length(min = 8)
    private String password;
}
