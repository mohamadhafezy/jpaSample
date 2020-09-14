package com.example.jpasample.service;

import com.example.jpasample.dao.EmployeeRepository;
import com.example.jpasample.dto.InputRequest;
import com.example.jpasample.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    public String saveEmployee(InputRequest<Employee> request){
        String curentUser=request.getLoggedInUser();
        request.setTimeZone(Calendar.getInstance().getTimeZone().getDisplayName());
        Employee employee=request.getEmployee();
        employee.setCreatedBy(curentUser);
        employeeRepository.save(employee);
        return "Employee saved successfully ";

    }
    public String updateEmployee(long id,double salary,InputRequest<Employee> request){
        Employee employee=employeeRepository.findById(id).get();
        if(employee!=null){
            employee.setSallery(salary);
            employee.setModifiedBy(request.getLoggedInUser());
            employeeRepository.saveAndFlush(employee);
        }
        else {
            throw new RuntimeException("employee not found with id:" + id);
        }
        return "employee updated successfully";
    }
}
