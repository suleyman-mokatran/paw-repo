package com.PAWCOMPANY.paw.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter

public class Doctor extends AppUser {

    @Column (nullable = false)
    String specialization;
    String availability;
    int experienceYears;


    @OneToMany(mappedBy = "Doctor", cascade = CascadeType.ALL)
    private List<Appointment> appointmentList;
}
