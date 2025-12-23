package org.example.dabacolis.service;

import org.example.dabacolis.dto.auth.LoginRequest;
import org.example.dabacolis.dto.auth.LoginResponse;
import org.example.dabacolis.entity.User;
import org.example.dabacolis.repository.UserRepository;
import org.example.dabacolis.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public LoginResponse login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword())
        );


        User user = userRepository.findByLogin(request.getLogin())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));


        String token = jwtService.generateToken(
                Map.of("role", user.getRole()), // Add role to JWT payload
                user
        );

        return LoginResponse.builder()
                .token(token)
                .login(user.getLogin())

                .role(user.getRole().name())
                .build();
    }
}
