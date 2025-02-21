package com.PAWCOMPANY.paw.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter


public class ServiceProvider extends AppUser {

    @OneToMany(mappedBy = "serviceProvider", cascade = CascadeType.ALL)
    private List<Service> serviceList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CompanyId", referencedColumnName = "CompanyId")
    private Company company;

}

