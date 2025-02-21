package com.PAWCOMPANY.paw.DTO;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ServiceProviderDTO extends AppUserDTO {

    private Integer companyId;

    private List<Integer> serviceIds;
}
