package com.example.demo.services;

import com.example.demo.Entity.Users;
import com.example.demo.dto.LoginDto;
import com.example.demo.dto.SignupDto;
import com.example.demo.repositories.userRepositories;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
@Builder
public class AuthenService {
    private userRepositories userRepositories;
    public String signup(SignupDto request) {

        Users existingUser = userRepositories
                        .findByEmail(request.getEmail())
                        .orElse(null);

        if(existingUser != null) {
            return "Email Already Exists";
        }
        Users user = new Users();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        userRepositories.save(user);

        return "User Registered Successfully";
    }

    public String login(LoginDto request) {

        Users user =
                userRepositories
                        .findByEmail(request.getEmail())
                        .orElse(null);

        if(user == null) {
            return "User Not Found";
        }

        if(user.getPassword()
                .equals(request.getPassword())) {

            return "Login Successful";
        }

        return "Invalid Password";
    }
}
