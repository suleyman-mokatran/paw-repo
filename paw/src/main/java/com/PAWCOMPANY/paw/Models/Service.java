package com.PAWCOMPANY.paw.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

    @OneToMany(mappedBy = "Service", cascade = CascadeType.ALL)
    private List<Appointment> appointmentList;

    @OneToMany(mappedBy = "Service", cascade = CascadeType.ALL)
    private List<Review> reviewList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CompanyId", referencedColumnName = "CompanyId")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "ServiceProviderId")
    private ServiceProvider serviceProvider;
}
