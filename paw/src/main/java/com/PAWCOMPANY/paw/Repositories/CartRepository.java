package com.PAWCOMPANY.paw.Repositories;

import com.PAWCOMPANY.paw.Models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
}