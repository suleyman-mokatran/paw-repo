package com.PAWCOMPANY.paw.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;


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
}
