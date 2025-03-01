package com.PAWCOMPANY.paw.Models;

import com.PAWCOMPANY.paw.Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity

@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
      int categoryId;


    @Enumerated(EnumType.STRING)
    Type type;

    @OneToMany(mappedBy = "PetCategory", cascade = CascadeType.ALL)
    private List<Pet> petList;

    @OneToMany(mappedBy = "ProductCategory", cascade = CascadeType.ALL)
    private List<Product> productList;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Pet> getPetList() {
        return petList;
    }

    public void setPetList(List<Pet> petList) {
        this.petList = petList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
