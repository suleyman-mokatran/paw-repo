package com.PAWCOMPANY.paw.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartDTO {

    @NotNull(message = "User ID is required")
    private Integer appUserId;

    private List<CartItemDTO> cartItems;

    private Integer orderId;
}
