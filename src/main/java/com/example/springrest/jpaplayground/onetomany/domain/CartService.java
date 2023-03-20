package com.example.springrest.jpaplayground.onetomany.domain;

import com.example.springrest.jpaplayground.onetomany.web.CartDto;
import com.example.springrest.jpaplayground.onetomany.web.CartItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public Cart findCart(Long id) {
        // ...
        return null;
    }

    public Cart addCart(CartDto dto) {
        // ...
        return null;
    }

    public Cart addCartItem(Long cartId, CartItemDto dto) {
        // ...
        return null;
    }
}
