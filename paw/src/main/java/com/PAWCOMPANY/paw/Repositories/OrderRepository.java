package com.PAWCOMPANY.paw.Repositories;

import com.PAWCOMPANY.paw.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
