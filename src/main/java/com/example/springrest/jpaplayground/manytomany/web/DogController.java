package com.example.springrest.jpaplayground.manytomany.web;

import com.example.springrest.jpaplayground.manytomany.domain.Dog;
import com.example.springrest.jpaplayground.manytomany.domain.DogService;
import com.example.springrest.jpaplayground.manytomany.domain.Toy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dog")
public class DogController {

    @Autowired
    private DogService dogService;

    @GetMapping("/{id}")
    public DogDto getDog(@PathVariable("id") Long id) {
        // ...
        return null;
    }

    @PostMapping
    public DogDto addDog(@RequestBody DogDto dog) {
        // ...
        return null;
    }

    @PostMapping("/{dogId}/toy")
    public DogDto createToyForDog(@PathVariable("dogId") Long dogId, @RequestBody ToyDto toy) {
        // ...
        return null;
    }

    @PutMapping("/{dogId}/toy")
    public DogDto addExistingToyToDog(@PathVariable("dogId") Long dogId, @RequestBody ToyIdDto toy) {
        // ...
        return null;
    }

    public static DogDto toDto(Dog dog) {
        // ...
        return null;
    }

    public static DogToyDto toDogToyDto(Toy toy) {
        // ...
        return null;
    }
}
