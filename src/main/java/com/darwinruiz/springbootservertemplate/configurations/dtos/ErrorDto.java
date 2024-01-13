package com.darwinruiz.springbootservertemplate.configurations.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ErrorDto {
    private Integer statusCode;
    private String error;
    private List<String> messages;
}
