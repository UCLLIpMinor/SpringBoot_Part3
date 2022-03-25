package com.example.springrest;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PatientQuery implements GraphQLQueryResolver {

    // URL: http://localhost:8080/graphiql

    @Autowired
    private AppService service;

    public String helloWorld() {
        return "Hello Elke";
    }

    public long countPatients () {
        return service.countPatients();
    }

    public List<Patient> getAllPatients () {
        return (List<Patient>) service.findAllPatients();
    }
}