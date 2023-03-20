package com.example.springrest.jpaplayground.manytomany.web;

import com.example.springrest.jpaplayground.manytomany.domain.Dog;
import com.example.springrest.jpaplayground.manytomany.domain.DogService;
import com.example.springrest.jpaplayground.manytomany.domain.Toy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/dog")
public class DogController {

    @Autowired
    private DogService dogService;

    @GetMapping("/{id}")
    public DogDto getDog(@PathVariable("id") Long id) {
        return toDto(dogService.findDog(id));
    }

    @PostMapping
    public DogDto addDog(@RequestBody DogDto dog) {
        return toDto(dogService.addDog(dog));
    }

    @PostMapping("/{dogId}/toy")
    public DogDto createToyForDog(@PathVariable("dogId") Long dogId, @RequestBody ToyDto toy) {
        return toDto(dogService.addToy(dogId, toy));
    }

    @PutMapping("/{dogId}/toy")
    public DogDto addExistingToyToDog(@PathVariable("dogId") Long dogId, @RequestBody ToyIdDto toy) {
        return toDto(dogService.addToyToDog(dogId, toy.getId()));
    }

    public static DogDto toDto(Dog dog) {
        DogDto dto = new DogDto();

        dto.setName(dog.getName());
        dto.setFavoriteToys(dog.getFavoriteToys().stream().map(DogController::toDogToyDto).collect(Collectors.toList()));

        return dto;
    }

    public static DogToyDto toDogToyDto(Toy toy) {
        DogToyDto dto = new DogToyDto();

        dto.setName(toy.getName());

        return dto;
    }
}
