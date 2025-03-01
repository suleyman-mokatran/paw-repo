package com.PAWCOMPANY.paw.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity


public class Doctor extends AppUser {

    @Column (nullable = true)
    String specialization;
    String availability;
    int experienceYears;


    @OneToMany(mappedBy = "Doctor", cascade = CascadeType.ALL)
    private List<Appointment> appointmentList;

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    @Override
    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    @Override
    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }
}
