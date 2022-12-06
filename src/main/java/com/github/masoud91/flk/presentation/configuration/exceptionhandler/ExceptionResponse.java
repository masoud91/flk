package com.github.masoud91.flk.presentation.configuration.exceptionhandler;

public class ExceptionResponse {
    private final String type;
    private final String title;
    private final String timestamp;

    private ExceptionResponse(String type, String title, String timestamp) {
        this.type = type;
        this.title = title;
        this.timestamp = timestamp;
    }

    public static ExceptionResponse create(String type, String title, String timestamp) {
        return new ExceptionResponse(type, title, timestamp);
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
