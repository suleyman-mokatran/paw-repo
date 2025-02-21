package com.PAWCOMPANY.paw.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "serviceproviders")

public class ServiceProvider extends AppUser {

    @OneToMany(mappedBy = "ServiceProvider", cascade = CascadeType.ALL)
    private List<Service> serviceList;


}

