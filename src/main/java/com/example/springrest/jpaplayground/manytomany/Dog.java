package com.example.springrest.jpaplayground.manytomany;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
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

    public Set<Toy> getFavoriteToys() {
        return favoriteToys;
    }

    public void setFavoriteToys(Set<Toy> favoriteToys) {
        this.favoriteToys = favoriteToys;
    }
}
