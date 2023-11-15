package com.microservice.product.controller;

import com.microservice.grpc.DiscountRequest;
import com.microservice.product.model.dto.*;
import com.microservice.product.service.DiscountService;
import com.microservice.product.service.grpc.CategoryDiscountGrpcService;
import com.microservice.product.service.grpc.DiscountGrpcService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/discount")
@AllArgsConstructor
public class DiscountController {
    private final DiscountGrpcService discountGrpcService;

    private final DiscountService discountService;

    private final CategoryDiscountGrpcService categoryDiscountGrpcService;

    @PostMapping("/grpc")
    public ResponseEntity<DiscountServiceResponse> callDiscountGrpcService(@RequestBody DiscountReq discountReq) {
        DiscountRequest discountRequest = DiscountRequest.newBuilder()
                .setCode(discountReq.getCode())
                .setPrice(discountReq.getPrice().floatValue())
                .setExternalCategoryId(discountReq.getExternalCategoryId())
                .build();

        return ResponseEntity.ok(discountGrpcService.getDiscount(discountRequest));
    }

    @PostMapping("/rest")
    public ResponseEntity<DiscountResp> callDiscountRestService(@RequestBody DiscountReq discountRequest){

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

    @PostMapping("/add/category/list/rest")
    public ResponseEntity<AddDiscountCategoryResp> addDiscountCategoryRest(@RequestBody AddDiscountCategoryRequest addDiscountCategoryRequest){
       return ResponseEntity.ok(discountService.addDiscountCategory(addDiscountCategoryRequest));
    }

    @PostMapping("/add/category/list/grpc")
    public ResponseEntity<AddDiscountCategoryResp> addDiscountCategoryGrpc(@RequestBody AddDiscountCategoryRequest addDiscountCategoryRequest){
        return ResponseEntity.ok(discountGrpcService.addDiscountCategoryList(addDiscountCategoryRequest));
    }
}


