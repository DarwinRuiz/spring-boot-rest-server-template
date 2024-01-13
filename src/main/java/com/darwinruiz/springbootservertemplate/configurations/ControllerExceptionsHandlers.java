package com.darwinruiz.springbootservertemplate.configurations;

import java.util.LinkedList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.darwinruiz.springbootservertemplate.configurations.dtos.ErrorDto;
import com.darwinruiz.springbootservertemplate.configurations.exceptions.RequestException;

@RestControllerAdvice
public class ControllerExceptionsHandlers extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDto> expiredJwtExceptionHandler(RuntimeException exception) {
        List<String> messages = new LinkedList<String>();
        messages.add(exception.getMessage());
        ErrorDto error = ErrorDto.builder().statusCode(401).error("jwt").messages(messages)
                .build();

        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(RequestException.class)
    public ResponseEntity<ErrorDto> requestExceptionHandler(RequestException exception) {

        ErrorDto error = ErrorDto.builder().statusCode(exception.getCode().value()).error(exception.getMessage())
                .messages(exception.getMessages())
                .build();

        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

}