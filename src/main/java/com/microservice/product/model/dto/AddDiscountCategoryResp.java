package com.microservice.product.model.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddDiscountCategoryResp implements Serializable {
    private String result;
    private String resultExp;
}



