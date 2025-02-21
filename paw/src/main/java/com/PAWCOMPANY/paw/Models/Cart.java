package com.PAWCOMPANY.paw.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "cart")

public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int CartId;

    @OneToMany(mappedBy = "Cart", cascade = CascadeType.ALL)
    private List<CartItem> cartItemList;

    @OneToOne(mappedBy = "Order")
    private Order order;

    @OneToOne(mappedBy = "AppUser")
    private AppUser appUser;

}
