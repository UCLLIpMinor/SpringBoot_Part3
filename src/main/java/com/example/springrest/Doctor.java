package com.example.springrest;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Doctor {

    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "doctors")
    // mappedBy decides that this is the not owning or inverse side
    private List<Patient> patients = new ArrayList<Patient>();

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", unique = false, nullable = false, length = 100)
    @NotBlank(message = "name.missing")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
