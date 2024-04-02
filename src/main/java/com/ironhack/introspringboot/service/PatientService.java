package com.ironhack.introspringboot.service;

import com.ironhack.introspringboot.model.Patient;
import com.ironhack.introspringboot.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    public Patient getPatientById(Integer id){
        try {
            Optional<Patient> patientFound = patientRepository.findById(id);
            return patientFound.get();
        }catch (Exception e){
            throw new RuntimeException("Error: "+e.getMessage());
        }
    }

    public List<Patient> findAllByBirthBetween(Date startDate, Date endDate){
        try {
            return patientRepository.findByDateOfBirthBetween(startDate,endDate);

        }catch (Exception e){
            throw new RuntimeException("Error: "+e);
        }
    }

    public List<Patient> findAllByEmployeeDepartment(String department){
        try {
            return patientRepository.findAllByEmployeeDepartment(department);
        }catch (Exception e){
            throw new RuntimeException("Error: "+ e);
        }
    }

    public List<Patient> findAllByEmployeeStatusOff(){
        try {
            return patientRepository.findAllByEmployeeStatusOff();
        }catch (Exception e){
            throw new RuntimeException("Error: "+ e);
        }
    }
}
