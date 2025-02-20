package com.PAWCOMPANY.paw.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "doctors")
public class Doctor extends AppUser {

    @Column (nullable = false)
    String specialization;

    String availability;

    int experienceYears;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clinicid", referencedColumnName = "clinicId")
    int clinicID;

}
