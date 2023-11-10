package com.microservice.product.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryAddRequest {
    private CategoryDto categoryDto;
}
