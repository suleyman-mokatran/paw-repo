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
}
