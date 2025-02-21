package com.PAWCOMPANY.paw.Models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "appusers")

public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int AppUserId;

    String firstname;
    String lastname;
    Date BirthDate;
    String gender;

    @Column (unique = true,nullable = false)
    String email;
    @Column (unique = true,nullable = false)
    int phone;
    Image profile;
    String Role;
    String address;
    String password;

    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL)
    private List<Appointment> appointmentList;

    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL)
    private List<Pet> petList;

    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL)
    private List<Pet> AdoptedPets;

    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL)
    private List<Order> orderList;

    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL)
    private List<Review> reviewList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CartId", referencedColumnName = "CartId")
    private Cart cart;
}
