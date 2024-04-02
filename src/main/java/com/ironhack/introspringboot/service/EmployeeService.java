package com.ironhack.introspringboot.service;

import com.ironhack.introspringboot.model.Employee;
import com.ironhack.introspringboot.model.Status;
import com.ironhack.introspringboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee findEmployeeById(Integer id){
        try {
            Optional<Employee> employeeFound = employeeRepository.findById(id);
            return employeeFound.get();
        }catch (Exception e){
            throw new RuntimeException("Error:"+ e.getMessage());
        }
    }

    public List<Employee> findAllByStatus(String status){
        Status statusUpperCase = Status.valueOf(status.toUpperCase());
        return employeeRepository.findAllByStatus(statusUpperCase);
    }

    public List<Employee> findAllByDepartment(String department){
        return employeeRepository.findAllByDepartment(department);
    }
}
