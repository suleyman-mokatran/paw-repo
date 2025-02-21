package com.PAWCOMPANY.paw.DTO;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class AppUserDTO {

    private int appUserId;

    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstname;

    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastname;

    @NotNull(message = "Birth date is required")
    @Past(message = "Birth date must be in the past")
    private Date birthDate;

    @NotBlank(message = "Gender is required")
    @Pattern(regexp = "Male|Female", message = "Gender must be Male, Female")
    private String gender;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @NotNull(message = "Phone number is required")
    @Min(value = 10000000, message = "Phone number must be at least 8 digits")
    private Integer phone;

    @NotBlank(message = "Role is required")
    private String role;

    @NotBlank(message = "Address is required")
    private String address;

    private List<Integer> appointmentIds;

    private List<Integer> petIds;

    private List<Integer> adoptedPetIds;
    private List<Integer> orderIds;
    private List<Integer> reviewIds;

    private Integer cartId;
}
