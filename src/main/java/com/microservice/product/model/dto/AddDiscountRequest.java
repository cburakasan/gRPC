package com.microservice.product.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AddDiscountRequest implements Serializable {
    private DiscountDto discountDto;
    private CategoryDto categoryDto;
}
