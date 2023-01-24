package com.programming.spring.service;

import com.programming.spring.dto.AuthenticationRequest;
import com.programming.spring.dto.AuthenticationResponse;
import com.programming.spring.dto.RegisterRequest;
import com.programming.spring.entity.Role;
import com.programming.spring.entity.UserEntity;
import com.programming.spring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    public void signup(RegisterRequest request){
        UserEntity user = new UserEntity();
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        String password = passwordEncoder.encode(request.getPassword());
        user.setPassword(password);
        user.setRole(Role.USER);

        repository.save(user);
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request){
        return null;
    }
}
