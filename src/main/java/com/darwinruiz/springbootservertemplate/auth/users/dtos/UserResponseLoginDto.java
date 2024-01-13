package com.darwinruiz.springbootservertemplate.auth.users.dtos;

import java.util.Set;

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
public class UserResponseLoginDto {
    private Integer id;
    private String email;
    private String name;
    private Boolean isActive;
    private Set<String> roles;
}
