package com.PAWCOMPANY.paw.DTO;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AppointmentDTO {

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be a positive value")
    private float price;

    @NotNull(message = "Time is required")
    @Future(message = "Appointment time must be in the future")
    private Date time;

    @NotNull(message = "Status is required")
    @Pattern(regexp = "^(Pending|Confirmed|Canceled|Completed)$", message = "Status must be 'Pending', 'Confirmed', 'Canceled', or 'Completed'")
    private String status;

    private Integer appUserId;

    private Integer serviceId;

    private Integer doctorId;
}
