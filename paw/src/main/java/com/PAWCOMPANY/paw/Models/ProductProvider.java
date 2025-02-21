package com.PAWCOMPANY.paw.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "productproviders")
public class ProductProvider extends AppUser {

    @OneToMany(mappedBy = "ProductProvider", cascade = CascadeType.ALL)
    private List<Product> productList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CompanyId", referencedColumnName = "CompanyId")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "AppUserId")
    private AppUser appUser;
}
