package com.example.demo.repositories;

import com.example.demo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

//using JPA repository we can perform crud operations on our table
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
