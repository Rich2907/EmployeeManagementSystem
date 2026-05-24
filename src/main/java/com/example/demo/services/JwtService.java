package com.example.demo.services;
import com.example.demo.Entity.Users;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    private final String SECRET_KEY =
            "mysecretkeymysecretkeymysecretkey12345";

    public String generateToken(Users user) {

        return Jwts.builder()

                .setSubject(user.getEmail())

                .claim("role", user.getRole())

                .setIssuedAt(new Date())

                .setExpiration(
                        new Date(
                                System.currentTimeMillis()
                                        + 1000 * 60 * 60
                        )
                )

                .signWith(getSignKey(),
                        SignatureAlgorithm.HS256)

                .compact();
    }

    public String extractEmail(String token) {

        return Jwts.parserBuilder()

                .setSigningKey(getSignKey())

                .build()

                .parseClaimsJws(token)

                .getBody()

                .getSubject();
    }

    public boolean isTokenValid(String token,
                                Users user) {

        String email = extractEmail(token);

        return email.equals(user.getEmail());
    }

    private Key getSignKey() {

        return Keys.hmacShaKeyFor(
                SECRET_KEY.getBytes()
        );
    }
}