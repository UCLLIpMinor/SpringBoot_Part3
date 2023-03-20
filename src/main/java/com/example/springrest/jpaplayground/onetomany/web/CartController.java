package com.example.springrest.jpaplayground.onetomany.web;

import com.example.springrest.jpaplayground.onetomany.domain.Cart;
import com.example.springrest.jpaplayground.onetomany.domain.CartItem;
import com.example.springrest.jpaplayground.onetomany.domain.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{id}")
    public CartDto getCart(@PathVariable("id") Long id) {
        // ...
        return null;
    }

    @PostMapping
    public CartDto addCart(@RequestBody CartDto cart) {
        // ...
        return null;
    }

    @PostMapping("/{cartId}/cartItem")
    public CartDto addCartItemToCart(@PathVariable("cartId") Long cartId, @RequestBody CartItemDto cartItem) {
        // ...
        return null;
    }

    public static CartDto toDto(Cart cart) {
        // ...
        return null;
    }

    public static CartItemDto toDto(CartItem cartItem) {
        // ...
        return null;
    }
}
