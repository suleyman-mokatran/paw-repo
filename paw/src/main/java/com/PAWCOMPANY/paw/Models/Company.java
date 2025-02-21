package com.PAWCOMPANY.paw.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int CompanyId;
    String CompanyName;
    String CompanyAddress;

    @OneToMany(mappedBy = "Company", cascade = CascadeType.ALL)
    private List<Product> productList;

    @OneToOne(mappedBy = "company")
    private ServiceProvider serviceProvider;

    @OneToOne(mappedBy = "company")
    private ProductProvider productProvider;


}
