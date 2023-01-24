package com.programming.spring.controller;

import com.programming.spring.mapstruct.dto.LoginRequest;
import com.programming.spring.mapstruct.dto.AuthenticationResponse;
import com.programming.spring.mapstruct.dto.RegisterRequest;
import com.programming.spring.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody RegisterRequest request){
        log.info("Sign Up Endpoint ...");
        authenticationService.signup(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest request){
        log.info("Login Endpoint...");
        var response = authenticationService.login(request);
        return ResponseEntity.ok(response);
    }

}
