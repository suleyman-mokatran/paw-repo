package com.PAWCOMPANY.paw.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "services")

public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ServiceId;

    String Name;
    String Description;
    float Price;
}
