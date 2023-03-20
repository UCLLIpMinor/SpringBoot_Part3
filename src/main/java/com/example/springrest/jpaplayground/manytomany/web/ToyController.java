package com.example.springrest.jpaplayground.manytomany.web;

import com.example.springrest.jpaplayground.manytomany.domain.DogService;
import com.example.springrest.jpaplayground.manytomany.domain.Toy;
import com.example.springrest.jpaplayground.manytomany.domain.ToyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/toy")
public class ToyController {

    @Autowired
    private ToyService toyService;

    @GetMapping("/{id}")
    public ToyDto getToy(@PathVariable("id") Long toyId) {
        return toDto(toyService.findToy(toyId));
    }

    public static ToyDto toDto(Toy toy) {
        ToyDto dto = new ToyDto();

        dto.setName(toy.getName());
        dto.setFavoritedBy(toy.getFavoritedBy().stream().map(DogController::toDto).collect(Collectors.toList()));

        return dto;
    }
}
