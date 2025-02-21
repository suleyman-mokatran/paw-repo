package com.PAWCOMPANY.paw.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.List;
import java.util.concurrent.ConcurrentMap;


@Entity
@Getter
@Setter
@Table(name= "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ProductId;

    String ProductName;
    String Description;
    float Price;
    int Stock;
    Image ProductImage;

    @ManyToOne
    @JoinColumn(name = "ProductProviderId")
    private ProductProvider productProvider;

    @OneToMany(mappedBy = "Product", cascade = CascadeType.ALL)
    private List<Review> reviewList;

    @ManyToOne
    @JoinColumn(name = "Category")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "Company")
    private Company company;

    @ManyToMany
    @JoinTable(
            name = "CartItem_Product",
            joinColumns = @JoinColumn(name = "ProductId"),
            inverseJoinColumns = @JoinColumn(name = "CartItemId")
    )
    private List<CartItem> cartItemList ;

    @ManyToMany
    @JoinTable(
            name = "OrderItem_Product",
            joinColumns = @JoinColumn(name = "ProductId"),
            inverseJoinColumns = @JoinColumn(name = "OrderItemId")
    )
    private List<OrderItem> orderItemList ;
}
