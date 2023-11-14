package com.microservice.product.service;

import com.microservice.product.model.dto.*;

public interface DiscountService {
    DiscountResp callGrpcRestService(DiscountReq discountRequest);

    AllCategoryResponse getAllCategoriesByDiscount();

    AddDiscountCategoryResp addDiscountCategory(AddDiscountCategoryRequest addDiscountCategoryRequest);
}
