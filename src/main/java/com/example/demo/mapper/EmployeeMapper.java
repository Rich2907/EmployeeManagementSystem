package com.example.demo.mapper;

import com.example.demo.Entity.Employee;
import com.example.demo.dto.EmployeeDto;
//Mapper class to map dto to entity
public class EmployeeMapper {
    public static EmployeeDto employeetoemployeeDto(Employee emp)
    {
        return new EmployeeDto(emp.getId(),emp.getFirstName(),emp.getLastName(),emp.getEmail());
    }


    public static Employee employeeDtotoemployee(EmployeeDto emp)
    {
        return new Employee(emp.getId(),emp.getFirstName(),emp.getLastName(),emp.getEmail());
    }
}
