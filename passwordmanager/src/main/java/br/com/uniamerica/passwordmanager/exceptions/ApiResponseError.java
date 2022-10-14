package br.com.uniamerica.passwordmanager.exceptions;

import lombok.Getter;

import java.time.Instant;

@Getter
public class ApiResponseError {

    private Instant timestamp;
    private String message;
    private String path;

    public ApiResponseError(String message, String path) {
        this.message = message;
        this.path = path;
        this.timestamp = Instant.now();
    }
}
