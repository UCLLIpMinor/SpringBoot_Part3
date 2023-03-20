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
        return cartRepository.findById(id).orElseThrow(() -> new RuntimeException("Cart not found"));
    }

    public Cart addCart(CartDto dto) {
        Cart cart = new Cart();
        return cartRepository.save(cart);
    }

    public Cart addCartItem(Long cartId, CartItemDto dto) {
        Cart cart = findCart(cartId);

        CartItem cartItem = new CartItem();
        cartItem.setName(dto.getName());
        cartItem.setAmount(dto.getAmount());
        cartItem.setPrice(dto.getPrice());

        cart.addItem(cartItem);
        return cartRepository.save(cart);
    }
}
