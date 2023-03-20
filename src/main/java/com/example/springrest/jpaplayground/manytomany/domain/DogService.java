package com.example.springrest.jpaplayground.manytomany.domain;

import com.example.springrest.jpaplayground.manytomany.web.DogDto;
import com.example.springrest.jpaplayground.manytomany.web.ToyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class DogService {

    @Autowired
    private DogRepository dogRepository;

    @Autowired
    private ToyService toyService;

    public Dog addDog(DogDto dogDto) {
        Dog dog = new Dog();
        dog.setName(dogDto.getName());

        return dogRepository.save(dog);
    }

    public Dog findDog(Long id) {
        return dogRepository.findById(id).orElseThrow(() -> new RuntimeException("Dog not found"));
    }

    public Dog addToy(Long dogId, ToyDto toyDto) {
        Dog dog = findDog(dogId);

        Toy toy = new Toy();
        toy.setName(toyDto.getName());
        dog.addToy(toy);

        return dogRepository.save(dog);
    }

    public Dog addToyToDog(Long dogId, Long toyId) {
        Dog dog = findDog(dogId);
        Toy toy = toyService.findToy(toyId);

        dog.addToy(toy);
        return dogRepository.save(dog);
    }
}
