package com.github.masoud91.flk.presentation.dto;

public class GreetingResponseDto {

    private final String message;

    public GreetingResponseDto(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
