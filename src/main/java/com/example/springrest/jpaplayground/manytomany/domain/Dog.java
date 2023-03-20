package com.example.springrest.jpaplayground.manytomany.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "toy_favorites",
        joinColumns = @JoinColumn(name = "dog_id"),
        inverseJoinColumns = @JoinColumn(name = "toy_id")
    )
    private Set<Toy> favoriteToys;

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

    public Set<Toy> getFavoriteToys() {
        if (favoriteToys == null) {
            this.favoriteToys = new HashSet<>();
        }

        return favoriteToys;
    }

    public void addToy(Toy toy) {
        this.getFavoriteToys().add(toy);
        toy.addFavoritedBy(this);
    }
}
