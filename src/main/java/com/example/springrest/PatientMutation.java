package com.example.springrest;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientMutation implements GraphQLMutationResolver {

    @Autowired
    private AppService service;

    public Patient newPatient (String name, String email, int age) {
        Patient patient = new Patient();
        patient.setName(name);
        patient.setEmail(email);
        patient.setAge(age);
        service.addPatient(patient);
        return patient;
    }
}
