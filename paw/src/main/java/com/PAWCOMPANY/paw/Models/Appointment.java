package com.PAWCOMPANY.paw.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "appointment")

public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int AppointmentId;
    float price;
    Date Time;
    String Status;

    @ManyToOne
    @JoinColumn(name = "AppUserId")
    private AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "ServiceId")
    private Service service;

    @ManyToOne
    @JoinColumn(name = "DoctorId")
    private Doctor doctor;


}
