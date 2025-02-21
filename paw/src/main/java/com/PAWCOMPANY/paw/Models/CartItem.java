package com.PAWCOMPANY.paw.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cartitems")

public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int CartItemId;
    int Quantity;
    float Price;
}
