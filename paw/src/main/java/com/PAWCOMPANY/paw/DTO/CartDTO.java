package com.PAWCOMPANY.paw.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartDTO {

    private Integer appUserId;

    private List<CartItemDTO> cartItems;

    private Integer orderId;
}
