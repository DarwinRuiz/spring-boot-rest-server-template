package com.darwinruiz.springbootservertemplate.domain;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path = "/api/v1/test")
@Tag(name = "Test Server")
public class TestController {

    @Operation(description = "Get Endpoint for test the correct functionality server", summary = "This is a summary for get endpoint", responses = {
            @ApiResponse(description = "Success", responseCode = "200", content = {
                    @Content(mediaType = "application/json") }),
            @ApiResponse(description = "Unauthorize / Token Request", responseCode = "403", content = {
                    @Content(mediaType = "application/json") })
    })

    @GetMapping
    public Map<String, Object> getData() {
        System.out.println("Hola");
        try {
            Map<String, Object> data = new HashMap<String, Object>();

            data.put("Message", "Consulta Exitosa");

            return data;
        } catch (Exception e) {
            Map<String, Object> error = new HashMap<String, Object>();

            error.put("error", e.getMessage());

            return error;
        }
    }
}
