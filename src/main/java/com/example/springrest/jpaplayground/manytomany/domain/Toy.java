package com.example.springrest.jpaplayground.manytomany.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Toy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "favoriteToys")
    private Set<Dog> favoritedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Dog> getFavoritedBy() {
        if (favoritedBy == null) {
            favoritedBy = new HashSet<>();
        }

        return favoritedBy;
    }

    public void addFavoritedBy(Dog dog) {
        this.getFavoritedBy().add(dog);
    }
}
