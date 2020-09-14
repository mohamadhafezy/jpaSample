package com.example.jpasample.controller;

import com.example.jpasample.dto.InputRequest;
import com.example.jpasample.model.Employee;
import com.example.jpasample.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @PostMapping("/addEmployee")
    public String saveEmployee(@RequestBody InputRequest<Employee> request){
     return employeeService.saveEmployee(request);
    }
    @PostMapping("/updateEmployee/{id}/{salary}")
    public String updateEmployee(@PathVariable long id,@PathVariable double salary,@RequestBody InputRequest request){
        return employeeService.updateEmployee(id,salary,request);
    }
}
