package com.microservice.product.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductAddResponse extends BaseResponse {
    private ProductDto productDto;
}
