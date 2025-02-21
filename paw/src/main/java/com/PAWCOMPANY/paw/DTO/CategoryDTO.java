package com.PAWCOMPANY.paw.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {

    @NotNull(message = "Category name is required")
    @Size(min = 2, max = 50, message = "Category name must be between 2 and 50 characters")
    private String categoryName;

    @NotNull(message = "Category type is required")
    @Size(min = 2, max = 50, message = "Category type must be between 2 and 50 characters")
    private String categoryType;
}
