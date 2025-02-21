package com.PAWCOMPANY.paw.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "orders")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int OrderId;
    float TotalPrice;
    String  Status;

    @OneToMany(mappedBy = "Order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItemList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CartId", referencedColumnName = "CartId")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "AppUserId")
    private AppUser appUser;
}
