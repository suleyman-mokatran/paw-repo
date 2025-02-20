package com.PAWCOMPANY.paw.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "petinfos")
public class petInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int infoId;

    String allergies;
    String dietoryPreferences;

    String medicalConditions;
        Date createdAt;
        Date lastVetVisit;
        Date NextVetVisit;

}
