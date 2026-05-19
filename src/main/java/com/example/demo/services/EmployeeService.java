package com.example.demo.services;

import com.example.demo.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeByid(Long employeeid);

    List<EmployeeDto> getAllEmployee();

    EmployeeDto updateEmployee(Long employeeid, EmployeeDto employeedto);
    void deleteEmployee(Long employeeid);
}
