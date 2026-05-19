package com.example.demo.services.EmployeeServiceImpl;

import com.example.demo.Entity.Employee;
import com.example.demo.Exception.resourceNotFoundException;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.mapper.EmployeeMapper;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.employeeDtotoemployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.employeetoemployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeByid(Long employeeid) {
     Employee employee=  employeeRepository.findById(employeeid).orElseThrow(()->
                new resourceNotFoundException("id does  not exist"+employeeid));
     return EmployeeMapper.employeetoemployeeDto(employee);
    }
}
