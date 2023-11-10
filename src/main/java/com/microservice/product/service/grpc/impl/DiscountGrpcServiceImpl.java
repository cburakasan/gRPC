package com.microservice.product.service.grpc.impl;

import com.microservice.grpc.DiscountRequest;
import com.microservice.grpc.DiscountResponse;
import com.microservice.grpc.DiscountServiceGrpc;
import com.microservice.product.model.dto.DiscountServiceResponse;
import com.microservice.product.service.grpc.DiscountGrpcService;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DiscountGrpcServiceImpl implements DiscountGrpcService {
    @GrpcClient("grpc-discount-service")
    private DiscountServiceGrpc.DiscountServiceBlockingStub discountServiceBlockingStub;

    @Override
    public DiscountServiceResponse getDiscount(DiscountRequest discountRequest) {

        DiscountResponse discount = discountServiceBlockingStub.getDiscount(discountRequest);

        return DiscountServiceResponse.builder()
                .newPice(BigDecimal.valueOf(discount.getNewPrice()))
                .result(discount.getResponse().getStatusCode())
                .message(discount.getResponse().getMessage())
                .build();
    }
}
