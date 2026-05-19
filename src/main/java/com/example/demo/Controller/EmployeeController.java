package com.example.demo.Controller;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.services.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

        private  EmployeeService employeeService;
        // Build Add Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    //Build GET Employee By id REST API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeid)
    {
        EmployeeDto savedEmployeeDto  =employeeService.getEmployeeByid(employeeid);
        return ResponseEntity.ok(savedEmployeeDto);
    }
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee()
    {
        List<EmployeeDto> savedemployelist = employeeService.getAllEmployee();
        return ResponseEntity.ok(savedemployelist);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeid,@RequestBody  EmployeeDto upemployeedto)
    {
        EmployeeDto employeesaved =employeeService.updateEmployee(employeeid,upemployeedto);
        return new ResponseEntity<>(employeesaved, HttpStatus.CREATED);
    }
    @DeleteMapping({"id"})
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeid)
    {
        employeeService.deleteEmployee(employeeid);
        return ResponseEntity.ok("Deleted successfully");
    }

}
