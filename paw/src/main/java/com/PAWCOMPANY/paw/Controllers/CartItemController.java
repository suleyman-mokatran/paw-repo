package com.PAWCOMPANY.paw.Controllers;

import com.PAWCOMPANY.paw.Models.Cart;
import com.PAWCOMPANY.paw.Models.CartItem;
import com.PAWCOMPANY.paw.Services.CartItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cartitems")
public class CartItemController {
    private final CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @GetMapping
    public List<CartItem> getAllCartItems() {
        return cartItemService.getAllCartItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartItem> getCartItemById(@PathVariable int id) {
        return cartItemService.getCartItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/createcartitem")
    public ResponseEntity<?> createCartItem(@RequestBody CartItem cartItem) {
        cartItemService.saveCartItem(cartItem);
        return ResponseEntity.ok(cartItem);
    }

    @DeleteMapping("/deletcartitem/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable int id) {
        cartItemService.deleteCartItem(id);
        return ResponseEntity.noContent().build();
    }
}
