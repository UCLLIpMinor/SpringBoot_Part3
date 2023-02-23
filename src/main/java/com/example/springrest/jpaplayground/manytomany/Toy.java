package com.example.springrest.jpaplayground.manytomany;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Toy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "favoriteToys")
    private Set<Dog> favoritedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Dog> getFavoritedBy() {
        return favoritedBy;
    }

    public void setFavoritedBy(Set<Dog> favoritedBy) {
        this.favoritedBy = favoritedBy;
    }
}
