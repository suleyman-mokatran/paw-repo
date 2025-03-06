package com.PAWCOMPANY.paw.Controllers;


import com.PAWCOMPANY.paw.Models.Cart;
import com.PAWCOMPANY.paw.Services.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getCartById(@PathVariable int id) {
        return cartService.getCartById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/createcart")
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
         cartService.saveCart(cart);
         return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/deletecart/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable int id) {
        cartService.deleteCart(id);
        return ResponseEntity.noContent().build();
    }
}
