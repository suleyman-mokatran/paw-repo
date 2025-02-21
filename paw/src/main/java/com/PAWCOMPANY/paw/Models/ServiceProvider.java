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
    private List<Service> serviceList;

}

