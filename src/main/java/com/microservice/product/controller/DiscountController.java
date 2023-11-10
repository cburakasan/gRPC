package com.microservice.product.controller;

import com.microservice.grpc.DiscountRequest;
import com.microservice.product.model.dto.*;
import com.microservice.product.service.DiscountService;
import com.microservice.product.service.grpc.CategoryDiscountGrpcService;
import com.microservice.product.service.grpc.DiscountGrpcService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/discount")
@AllArgsConstructor
public class DiscountController {
    private final DiscountGrpcService discountGrpcService;

    private final DiscountService discountService;

    private final CategoryDiscountGrpcService categoryDiscountGrpcService;

    @GetMapping("/grpc")
    public ResponseEntity<DiscountServiceResponse> callDiscountGrpcService() {
        DiscountRequest discountRequest = DiscountRequest.newBuilder()
                .setCode("CBA")
                .setPrice(100)
                .setExternalCategoryId(518)
                .build();

        return ResponseEntity.ok(discountGrpcService.getDiscount(discountRequest));
    }

    @GetMapping("/rest")
    public ResponseEntity<DiscountResp> callDiscountRestService(){
        DiscountReq discountRequest = DiscountReq.builder()
                .code("CBA")
                .price(new BigDecimal(100))
                .externalCategoryId(518)
                .build();

        return ResponseEntity.ok(discountService.callGrpcRestService(discountRequest));
    }

    @GetMapping("/categories/rest")
    public ResponseEntity<AllCategoryResponse> getAllDiscountCategory() {
        return ResponseEntity.ok(discountService.getAllCategoriesByDiscount());
    }

    @GetMapping("/categories/grpc")
    public ResponseEntity<AllCategoryResp> getAllDiscountCategoryByGrpc(){
        return ResponseEntity.ok(categoryDiscountGrpcService.getAllCategoryByDiscount());
    }
}


