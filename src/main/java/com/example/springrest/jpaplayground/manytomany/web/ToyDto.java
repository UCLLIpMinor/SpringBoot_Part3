package com.example.springrest.jpaplayground.manytomany.web;

import java.util.List;

public class ToyDto {

    private String name;

    private List<DogDto> favoritedBy;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DogDto> getFavoritedBy() {
        return favoritedBy;
    }

    public void setFavoritedBy(List<DogDto> favoritedBy) {
        this.favoritedBy = favoritedBy;
    }
}
