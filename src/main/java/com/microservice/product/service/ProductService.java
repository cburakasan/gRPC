package com.microservice.product.service;


import com.microservice.product.model.dto.ProductAddRequest;
import com.microservice.product.model.dto.ProductAddResponse;
import com.microservice.product.model.dto.ProductListResponse;

public interface ProductService {
    ProductAddResponse productAdd(ProductAddRequest productAddRequest);

    ProductListResponse getAllProduct();
}
