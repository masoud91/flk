package com.github.masoud91.flk.presentation.rest;

import com.github.masoud91.flk.presentation.dto.GreetingRequestDto;
import com.github.masoud91.flk.presentation.dto.GreetingResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/greetings")
public class GreetingsController {

    @PostMapping()
    ResponseEntity<GreetingResponseDto> greeting(@RequestBody GreetingRequestDto requestDto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new GreetingResponseDto("Welcome 003 " + requestDto.getUsername() + "!"));
    }

}
