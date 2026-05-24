package com.example.demo.services;

import com.example.demo.dto.*;
import com.example.demo.Entity.Users;
import com.example.demo.repositories.userRepositories;

import lombok.AllArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenService {

    private userRepositories userRepository;

    private PasswordEncoder passwordEncoder;

    private JwtService jwtService;

    public String signup(SignupDto request) {

        Users existingUser =
                userRepository
                        .findByEmail(request.getEmail())
                        .orElse(null);

        if(existingUser != null) {
            return "Email Already Exists";
        }

        Users user = new Users();

        user.setName(request.getName());

        user.setEmail(request.getEmail());

        user.setPassword(
                passwordEncoder.encode(
                        request.getPassword()
                )
        );

        user.setRole("USER");

        userRepository.save(user);

        return "User Registered Successfully";
    }

    public AuthDto login(LoginDto request) {

        Users user =
                userRepository
                        .findByEmail(request.getEmail())
                        .orElse(null);

        if(user == null) {
            throw new RuntimeException(
                    "User Not Found"
            );
        }

        boolean valid =
                passwordEncoder.matches(
                        request.getPassword(),
                        user.getPassword()
                );

        if(!valid) {
            throw new RuntimeException(
                    "Invalid Password"
            );
        }

        String token =
                jwtService.generateToken(user);

        return new AuthDto(token);
    }
}