package com.microservice.product.service.grpc.impl;

import com.microservice.grpc.*;
import com.microservice.product.model.dto.AddDiscountCategoryRequest;
import com.microservice.product.model.dto.AddDiscountCategoryResp;
import com.microservice.product.model.dto.DiscountServiceResponse;
import com.microservice.product.model.mapper.AddDiscountCategoryMapper;
import com.microservice.product.service.grpc.DiscountGrpcService;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DiscountGrpcServiceImpl implements DiscountGrpcService {
    @GrpcClient("grpc-discount-service")
    private DiscountServiceGrpc.DiscountServiceBlockingStub discountServiceBlockingStub;

    @GrpcClient("grpc-discountCategory-service")
    private DiscountCategoryServiceGrpc.DiscountCategoryServiceBlockingStub discountCategoryServiceBlockingStub;

    @Override
    public DiscountServiceResponse getDiscount(DiscountRequest discountRequest) {

        DiscountResponse discount = discountServiceBlockingStub.getDiscount(discountRequest);

        return DiscountServiceResponse.builder()
                .newPice(BigDecimal.valueOf(discount.getNewPrice()))
                .result(discount.getResponse().getStatusCode())
                .message(discount.getResponse().getMessage())
                .build();
    }

    @Override
    public AddDiscountCategoryResp addDiscountCategoryList(AddDiscountCategoryRequest addDiscountCategoryRequest) {

        AddDiscountCategoryResponse addDiscountCategoryResponse = discountCategoryServiceBlockingStub.addDiscountCategory(getGrpcRequest(addDiscountCategoryRequest));

        return AddDiscountCategoryResp.builder()
                .result(String.valueOf(addDiscountCategoryResponse.getResponse().getStatusCode()))
                .resultExp(addDiscountCategoryResponse.getResponse().getMessage())
                .build();
    }

    private com.microservice.grpc.AddDiscountCategoryRequest getGrpcRequest(AddDiscountCategoryRequest addDiscountCategoryRequest) {
        return AddDiscountCategoryMapper.INSTANCE.addDiscountCategoryRequestToGrpcAddDiscountCategoryRequest(addDiscountCategoryRequest);
    }
}
