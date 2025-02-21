package com.PAWCOMPANY.paw.DTO;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorDTO extends AppUserDTO {

    @NotNull(message = "Specialization is required")
    @Size(min = 2, max = 100, message = "Specialization must be between 2 and 100 characters")
    private String specialization;

    @NotNull(message = "Availability is required")
    @Size(min = 2, max = 50, message = "Availability must be between 2 and 50 characters")
    private String availability;

    @NotNull(message = "Experience years are required")
    @Min(value = 0, message = "Experience years must be a positive number")
    private int experienceYears;
}
