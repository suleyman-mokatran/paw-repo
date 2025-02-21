package com.PAWCOMPANY.paw.DTO;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDTO {

    @NotNull(message = "Total price is required")
    @Positive(message = "Total price must be a positive value")
    private float totalPrice;

    @NotNull(message = "Status is required")
    @Pattern(regexp = "^(Pending|Completed|Canceled)$", message = "Status must be 'Pending', 'Completed', or 'Canceled'")
    private String status;

    @NotNull(message = "Cart ID is required")
    private Integer cartId;

    @NotNull(message = "User ID is required")
    private Integer appUserId;

    private List<OrderItemDTO> orderItems;
}
