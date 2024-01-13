package com.darwinruiz.springbootservertemplate.configurations.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestException extends RuntimeException {
    private HttpStatus code;
    private List<String> messages;

    public RequestException(HttpStatus code, String message, List<String> messages) {
        super(message);
        this.code = code;
        this.messages = messages;
    }
}
