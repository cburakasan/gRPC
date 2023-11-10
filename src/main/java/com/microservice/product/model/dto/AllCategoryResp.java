package com.microservice.product.model.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AllCategoryResp implements Serializable {
    private List<AllCategoryDto> categoryList;
}



