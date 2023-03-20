package com.example.springrest.jpaplayground.onetomany.web;

import com.example.springrest.jpaplayground.onetomany.domain.Cart;
import com.example.springrest.jpaplayground.onetomany.domain.CartItem;
import com.example.springrest.jpaplayground.onetomany.domain.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{id}")
    public CartDto getCart(@PathVariable("id") Long id) {
        return toDto(cartService.findCart(id));
    }

    @PostMapping
    public CartDto addCart(@RequestBody CartDto cart) {
        return toDto(cartService.addCart(cart));
    }

    @PostMapping("/{cartId}/cartItem")
    public CartDto addCartItemToCart(@PathVariable("cartId") Long cartId, @RequestBody CartItemDto cartItem) {
        return toDto(cartService.addCartItem(cartId, cartItem));
    }

    public static CartDto toDto(Cart cart) {
        CartDto dto = new CartDto();

        dto.setId(cart.getId());
        dto.setItems(cart.getItems().stream().map(CartController::toDto).collect(Collectors.toList()));

        return dto;
    }

    public static CartItemDto toDto(CartItem cartItem) {
        CartItemDto dto = new CartItemDto();

        dto.setId(cartItem.getId());
        dto.setName(cartItem.getName());
        dto.setAmount(cartItem.getAmount());
        dto.setPrice(cartItem.getPrice());

        return dto;
    }
}
