package com.PAWCOMPANY.paw.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
      int categoryId;

    String categoryName;
    String categoryType;

    @OneToMany(mappedBy = "PetCategory", cascade = CascadeType.ALL)
    private List<Pet> petList;

    @OneToMany(mappedBy = "ProductCategory", cascade = CascadeType.ALL)
    private List<Product> productList;
}
