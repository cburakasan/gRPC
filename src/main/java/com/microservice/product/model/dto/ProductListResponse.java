package com.microservice.product.model.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductListResponse extends BaseResponse {
    private List<ProductDto> productDtoList;
}
