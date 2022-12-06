package com.github.masoud91.flk.presentation.configuration.exceptionhandler;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ServletWebRequest servletWebRequest = (ServletWebRequest) request;
        return new ResponseEntity<>(ExceptionResponse.create(servletWebRequest.getRequest().getRequestURI(), "Malformed JSON request", LocalDateTime.now().toString()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RestException.class)
    protected ResponseEntity<Object> handleCustomException(RestException ex) {
        return new ResponseEntity<>(ExceptionResponse.create("", ex.getMessage(), LocalDateTime.now().toString()), ex.getStatus());
    }
}
