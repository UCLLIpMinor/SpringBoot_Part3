package com.example.springrest.jpaplayground.manytomany.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToyService {

    @Autowired
    private ToyRepository toyRepository;

    public Toy findToy(Long id) {
        return toyRepository.findById(id).orElseThrow(() -> new RuntimeException("Toy not found"));
    }
}
