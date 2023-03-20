package com.example.springrest.jpaplayground.onetomany.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private Set<CartItem> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<CartItem> getItems() {
        if (items == null) {
            items = new HashSet<>();
        }

        return items;
    }

    public void addItem(CartItem item) {
        getItems().add(item);
        item.setCart(this);
    }

}
