package com.PAWCOMPANY.paw.DTO;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PetDTO {

    @NotNull(message = "Pet name is required")
    @Size(min = 2, max = 50, message = "Pet name must be between 2 and 50 characters")
    private String petName;

    @NotNull(message = "Gender is required")
    @Pattern(regexp = "^(Male|Female)$", message = "Gender must be 'Male' or 'Female'")
    private String gender;

    @NotNull(message = "Status is required")
    @Pattern(regexp = "^(Available|Adopted|Fostered|Lost|Found)$", message = "Status must be 'Available', 'Adopted', or 'Fostered'")
    private String status;

    @NotNull(message = "Weight is required")
    @Min(value = 1, message = "Weight must be a positive value")
    private int weight;

    @NotNull(message = "Age is required")
    @Min(value = 0, message = "Age must be a non-negative value")
    private int age;

    @NotNull(message = "Vaccination record is required")
    private Date vaccinationRecord;

    private String medicalConditions;

    private String allergies;

    private String dietaryPreferences;

    private Date lastVetVisit;

    private Date nextVetVisit;

    private Date createdAt;

    private Integer appUserId;

    private Integer adopterId;

    private Integer petCategoryId;
}
