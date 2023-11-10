package com.microservice.product.service;


import com.microservice.product.model.dto.CategoryAddRequest;
import com.microservice.product.model.dto.CategoryAddResponse;

public interface CategoryService {
    CategoryAddResponse categoryAdd(CategoryAddRequest categoryAddRequest);

}
