package com.PAWCOMPANY.paw.DTO;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReviewDTO {

    @NotNull(message = "Rating is required")
    @Pattern(regexp = "^(1|2|3|4|5)$", message = "Rating must be a value between 1 and 5")
    private String rating;

    @Size(max = 500, message = "Comment cannot exceed 500 characters")
    private String comment;

    private Date date;

    private Integer productId;

    private Integer appUserId;

    private Integer serviceId;
}
