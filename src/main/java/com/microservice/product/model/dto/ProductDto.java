package com.microservice.product.model.dto;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private String quantity;
    private String price;

    private CategoryDto category;
}
