package com.PAWCOMPANY.paw.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "orderitems")

public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int OrderItemsId;
    int quantity;
    Float price;

    @ManyToMany(mappedBy = "Products")
    private List<Product> productList ;

    @ManyToOne
    @JoinColumn(name = "OrderId")
    private Order order;
}
