package com.github.masoud91.flk.presentation.dto;

public class GreetingRequestDto {

    private String username;

    public GreetingRequestDto() {
    }

    public GreetingRequestDto(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
