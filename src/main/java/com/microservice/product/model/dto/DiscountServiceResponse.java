package com.microservice.product.model.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class DiscountServiceResponse implements Serializable {
    private String message;
    private boolean result;

    private BigDecimal newPice;
}
