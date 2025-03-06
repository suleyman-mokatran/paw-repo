package com.PAWCOMPANY.paw.Repositories;


import com.PAWCOMPANY.paw.Models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
}