package com.ironhack.introspringboot.repository;

import com.ironhack.introspringboot.model.Employee;
import com.ironhack.introspringboot.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer > {
    public List<Employee> findAllByStatus(Status status);
    public List<Employee> findAllByDepartment(String department);
}
