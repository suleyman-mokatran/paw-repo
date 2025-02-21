package com.PAWCOMPANY.paw.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "productproviders")
public class ProductProvider extends AppUser {
    private List<Product> productList;
}
