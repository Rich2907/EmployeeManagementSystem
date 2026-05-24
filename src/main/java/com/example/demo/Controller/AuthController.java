package com.example.demo.Controller;

import com.example.demo.dto.*;

import com.example.demo.services.AuthenService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")

@AllArgsConstructor

@CrossOrigin("*")
public class AuthController {

    private AuthenService authService;

    @PostMapping("/signup")
    public String signup(
            @RequestBody SignupDto request) {

        return authService.signup(request);
    }

    @PostMapping("/login")
    public AuthDto login(
            @RequestBody LoginDto request) {

        return authService.login(request);
    }
}