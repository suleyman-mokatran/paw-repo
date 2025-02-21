package com.PAWCOMPANY.paw.DTO;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductProviderDTO extends AppUserDTO {

    @NotNull(message = "Company ID is required")
    private Integer companyId;

    private List<Integer> productIds;
}
