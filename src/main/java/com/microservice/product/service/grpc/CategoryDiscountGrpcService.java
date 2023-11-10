package com.microservice.product.service.grpc;

import com.microservice.product.model.dto.AllCategoryResp;

public interface CategoryDiscountGrpcService {
    AllCategoryResp getAllCategoryByDiscount();

}
