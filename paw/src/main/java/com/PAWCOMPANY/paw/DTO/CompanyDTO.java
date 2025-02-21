package com.PAWCOMPANY.paw.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyDTO {

    @NotNull(message = "Company name is required")
    @Size(min = 2, max = 100, message = "Company name must be between 2 and 100 characters")
    private String companyName;

    @NotNull(message = "Company address is required")
    @Size(min = 5, max = 200, message = "Company address must be between 5 and 200 characters")
    private String companyAddress;
}
