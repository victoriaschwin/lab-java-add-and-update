package com.ironhack.introspringboot.repository;

import com.ironhack.introspringboot.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

    List<Patient> findByDateOfBirthBetween(Date startDate, Date endDate);
    @Query(value = "SELECT p.* FROM Patient p INNER JOIN employee e ON p.admitted_by = e.employee_id WHERE e.department = :department", nativeQuery = true)
    List<Patient> findAllByEmployeeDepartment(@Param("department") String department);

    @Query(value = "SELECT p.* FROM Patient p INNER JOIN Employee e ON p.admitted_by = e.employee_id WHERE e.status = OFF", nativeQuery = true)
    List<Patient> findAllByEmployeeStatusOff();

}

