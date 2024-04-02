package com.ironhack.introspringboot.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "patient")
@NoArgsConstructor
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer patient_id;
    private String name;
    private Date dateOfBirth;
    @ManyToOne
    @JoinColumn(name = "admitted_by")
    private Employee admittedBy;

    public Patient(String name, Date dateOfBirth, Employee admittedBy){
        this.name = name;
        this.dateOfBirth =dateOfBirth;
        this.admittedBy = admittedBy;
    }
}
