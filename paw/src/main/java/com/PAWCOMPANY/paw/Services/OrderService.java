package com.PAWCOMPANY.paw.Services;

import com.PAWCOMPANY.paw.Models.Order;
import com.PAWCOMPANY.paw.Repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(int id) {
        return orderRepository.findById(id);
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }
}
