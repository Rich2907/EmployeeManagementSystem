package com.example.demo.mapper;

import com.example.demo.Entity.Employee;
import com.example.demo.dto.EmployeeDto;
//Mapper class to map dto to entity
public class EmployeeMapper {
    public static EmployeeDto employeeDtotoemployee(Employee emp)
    {
        return new EmployeeDto(emp.getId(),emp.getFirstName(),emp.getLastName(),emp.getEmail());
    }


    public static Employee employeetoemployeeDto(EmployeeDto emp)
    {
        return new Employee(emp.getId(),emp.getFirstName(),emp.getLastName(),emp.getEmail());
    }

}
