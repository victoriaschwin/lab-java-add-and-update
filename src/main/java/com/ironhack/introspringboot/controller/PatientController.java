package com.ironhack.introspringboot.controller;

import com.ironhack.introspringboot.model.Patient;
import com.ironhack.introspringboot.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/patients")
    public List<Patient> getAllPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("/patients/{id}")
    public Patient getPatientById(@PathVariable(name = "id") Integer id){
        return patientService.getPatientById(id);
    }

    @GetMapping("/patients/birth-range")
    public List<Patient> getAllByBirthBetween(
            @RequestParam(name = "startDate") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE)Date startDate,
            @RequestParam (name = "endDate") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) Date endDate
            ){
        return patientService.findAllByBirthBetween(startDate,endDate);
    }

    @GetMapping("/patients/department/{department}")
    public List<Patient> getAllByEmployeeDepartment(@PathVariable(name = "department") String department){
        return patientService.findAllByEmployeeDepartment(department);
    }

    @GetMapping("/patients/status-off")
    public List<Patient> getAllByEmployeeStatusOff(){
        return patientService.findAllByEmployeeStatusOff();
    }
}
