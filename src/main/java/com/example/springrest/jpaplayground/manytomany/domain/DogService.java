package com.example.springrest.jpaplayground.manytomany.domain;

import com.example.springrest.jpaplayground.manytomany.web.DogDto;
import com.example.springrest.jpaplayground.manytomany.web.ToyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DogService {

    @Autowired
    private DogRepository dogRepository;

    @Autowired
    private ToyService toyService;

    public Dog addDog(DogDto dogDto) {
        // ...
        return null;
    }

    public Dog findDog(Long id) {
        // ...
        return null;
    }

    public Dog addToy(Long dogId, ToyDto toyDto) {
        // ...
        return null;
    }

    public Dog addToyToDog(Long dogId, Long toyId) {
        // ...
        return null;
    }
}
