package com.ironhack.introspringboot.controller;

import com.ironhack.introspringboot.model.Employee;
import com.ironhack.introspringboot.model.Status;
import com.ironhack.introspringboot.repository.EmployeeRepository;
import com.ironhack.introspringboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

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

    @PostMapping("/employees")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployees(@RequestBody Employee doctor) {
        employeeRepository.save(doctor);
    }

    @PatchMapping("/employees/status/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateEmployeeStatus(@PathVariable String id, @RequestBody Status status) {
        employeeService.updateEmployeeStatus(id, status);

    }

    @PatchMapping("/employees/department/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateEmployeeDepartment(@PathVariable String id, @RequestBody String department) {
        employeeService.updateEmployeeDepartment(id, department);
    }
}
