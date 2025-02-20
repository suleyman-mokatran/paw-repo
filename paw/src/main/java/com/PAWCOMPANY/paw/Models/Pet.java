package com.PAWCOMPANY.paw.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "pets")
public class Pet {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int PetId;

    @Column (nullable = false)
    String PetName;
    String gender;
    String status;
    int weight;
    int age;
}
