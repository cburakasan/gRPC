package com.microservice.product.model.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiscountReq implements Serializable {
    private Integer externalCategoryId;

    private String code;

    private BigDecimal price;
}
