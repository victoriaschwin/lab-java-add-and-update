package com.ironhack.introspringboot.model;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmployeeTest {
    @Test
    void createEmployee(){
        Employee employeeOne = new Employee();
        Employee employeeTwo = new Employee(182557,"cardiology","Antonia Jal", Status.ON_CALL);

        assertNotNull(employeeOne);
        assertNotNull(employeeTwo);
        assertEquals("cardiology", employeeTwo.getDepartment());
        assertEquals(182557, employeeTwo.getEmployeeId());
    }

    @Test
    void createPatient(){
        Date birthDate = new GregorianCalendar(1995, Calendar.FEBRUARY, 11).getTime();
        Employee employee = new Employee(182557,"cardiology","Antonia Jal", Status.ON_CALL);
        Patient patientOne = new Patient();
        Patient patientTwo = new Patient("Carola Diaz", birthDate,employee);

        System.out.println(patientTwo.getAdmittedBy());
        assertNotNull(patientOne);
        assertNotNull(patientTwo);
        assertEquals(birthDate, patientTwo.getDateOfBirth());
        assertEquals(employee.getEmployeeId(), patientTwo.getAdmittedBy().getEmployeeId());
    }
}
