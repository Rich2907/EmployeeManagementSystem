package com.example.demo.repositories;

import com.example.demo.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface userRepositories extends JpaRepository<Users, Long> {

    Optional<Users> findByEmail(String email);
}