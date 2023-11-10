package com.microservice.product.service.impl;

import com.microservice.product.model.dto.AllCategoryResponse;
import com.microservice.product.model.dto.DiscountReq;
import com.microservice.product.model.dto.DiscountResp;
import com.microservice.product.service.DiscountService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service

public class DiscountServiceImpl implements DiscountService {

    private RestTemplate restTemplate;

    public DiscountServiceImpl(
            @Qualifier("discountRestTemplate")
            RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public DiscountResp callGrpcRestService(DiscountReq discountRequest) {

        ResponseEntity<DiscountResp> discountRespResponseEntity =
                restTemplate.postForEntity("http://localhost:6616/api/discount/get", discountRequest, DiscountResp.class);

        return discountRespResponseEntity.getBody();
    }

    @Override
    public AllCategoryResponse getAllCategoriesByDiscount() {

        ResponseEntity<AllCategoryResponse> allCategoryResponse =
                restTemplate.getForEntity("http://localhost:6616/api/category/all", AllCategoryResponse.class);

        return allCategoryResponse.getBody();
    }
}
