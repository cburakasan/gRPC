package com.microservice.product.model.dto;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AllCategoryDto implements Serializable {
    private String name;
    private Integer externalId;
}
