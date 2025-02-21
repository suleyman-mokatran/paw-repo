package com.PAWCOMPANY.paw.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int PetId;

    String PetName;
    String Gender;
    String Status;
    int Weight;
    int Age;
    Date VaccinationRecord;
    String MedicalConditions;
    String Allergies;
    String DietaryPreferences;
    Date LastVetVisit;
    Date NextVetVisit;
    Date CreatedAt;

    @ManyToOne
    @JoinColumn(name = "PetUserId")
    private AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "AdopterId")
    private AppUser Adopter;

    @ManyToOne
    @JoinColumn(name = "CategoryId")
    private Category PetCategory;

}
