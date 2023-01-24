package com.programming.spring.service;

import com.programming.spring.entity.Role;
import com.programming.spring.entity.UserEntity;
import com.programming.spring.mapstruct.dto.AuthenticationResponse;
import com.programming.spring.mapstruct.dto.LoginRequest;
import com.programming.spring.mapstruct.dto.RegisterRequest;
import com.programming.spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authManager;
    private final JwtService jwtService;

    public void signup(RegisterRequest request) {
        UserEntity user = new UserEntity();
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        String password = passwordEncoder.encode(request.getPassword());
        user.setPassword(password);
        user.setRole(Role.USER);

        repository.save(user);
    }

    public AuthenticationResponse login(LoginRequest request) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        UserEntity user = repository.findByUsername(request.getUsername())
                .orElseThrow();
        String jwt = jwtService.generateToken(user);
        return new AuthenticationResponse(jwt);
    }
}
