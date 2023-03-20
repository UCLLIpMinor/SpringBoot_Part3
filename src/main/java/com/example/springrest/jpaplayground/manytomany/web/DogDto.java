package com.example.springrest.jpaplayground.manytomany.web;

import java.util.List;

public class DogDto {

    private String name;

    private List<DogToyDto> favoriteToys;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DogToyDto> getFavoriteToys() {
        return favoriteToys;
    }

    public void setFavoriteToys(List<DogToyDto> favoriteToys) {
        this.favoriteToys = favoriteToys;
    }
}
