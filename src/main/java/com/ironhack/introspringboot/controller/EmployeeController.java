package com.ironhack.introspringboot.controller;

import com.ironhack.introspringboot.model.Employee;
import com.ironhack.introspringboot.model.Status;
import com.ironhack.introspringboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){ return employeeService.getAllEmployees();}

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable(name = "id") Integer employeeID){
        return employeeService.findEmployeeById(employeeID);}

    @GetMapping("/employees/status/{status}")
    public List<Employee> getEmployeeByStatus(@PathVariable(name = "status") String status){
        return employeeService.findAllByStatus(status);
    }

    @GetMapping("/employees/department/{department}")
    public List<Employee> getEmployeeByDepartment(@PathVariable(name = "department") String department){
        return employeeService.findAllByDepartment(department);
    }
}
