package com.springboot_rsetapi.india.controller;


import com.springboot_rsetapi.india.entity.Employee;
import com.springboot_rsetapi.india.exeption.ResourceNotFoundException;
import com.springboot_rsetapi.india.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No employee with id = "+id));

        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employeeDetails) {
        Employee updateEmp = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No employee with id = "+id));

        updateEmp.setFirstname(employeeDetails.getFirstname());
        updateEmp.setLastname(employeeDetails.getLastname());
        updateEmp.setEmail(employeeDetails.getEmail());
        employeeRepository.save(updateEmp);

        return ResponseEntity.ok(updateEmp);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No employee with id = "+id));

        employeeRepository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
