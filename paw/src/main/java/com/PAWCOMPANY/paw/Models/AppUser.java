package com.PAWCOMPANY.paw.Models;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.util.Date;

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
    String email;
    int phone;
    Image profile;
    String Role;
    String address;
    String password;



}
