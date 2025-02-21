package com.PAWCOMPANY.paw.DTO;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ServiceDTO {

    @NotNull(message = "Service name is required")
    @Size(min = 2, max = 100, message = "Service name must be between 2 and 100 characters")
    private String name;

    @NotNull(message = "Description is required")
    @Size(min = 10, max = 500, message = "Description must be between 10 and 500 characters")
    private String description;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be a positive value")
    private float price;

    @NotNull(message = "Company ID is required")
    private Integer companyId;

    @NotNull(message = "Service provider ID is required")
    private Integer serviceProviderId;

    private List<Integer> appointmentIds;

    private List<Integer> reviewIds;
}
