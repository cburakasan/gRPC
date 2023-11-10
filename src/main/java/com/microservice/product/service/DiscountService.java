package com.microservice.product.service;

import com.microservice.product.model.dto.AllCategoryResponse;
import com.microservice.product.model.dto.DiscountReq;
import com.microservice.product.model.dto.DiscountResp;

public interface DiscountService {
    DiscountResp callGrpcRestService(DiscountReq discountRequest);

    AllCategoryResponse getAllCategoriesByDiscount();
}
