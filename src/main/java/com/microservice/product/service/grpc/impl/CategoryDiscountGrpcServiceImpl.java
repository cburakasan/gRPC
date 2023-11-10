package com.microservice.product.service.grpc.impl;

import com.microservice.grpc.AllCategoryRequest;
import com.microservice.grpc.AllCategoryResponse;
import com.microservice.grpc.Category;
import com.microservice.grpc.CategoryServiceGrpc;
import com.microservice.product.model.dto.AllCategoryResp;
import com.microservice.product.model.mapper.AllCategoryMapper;
import com.microservice.product.service.grpc.CategoryDiscountGrpcService;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryDiscountGrpcServiceImpl implements CategoryDiscountGrpcService {

    @GrpcClient("grpc-category-service")
    CategoryServiceGrpc.CategoryServiceBlockingStub categoryServiceBlockingStub;
    @Override
    public AllCategoryResp getAllCategoryByDiscount() {

        AllCategoryResponse allCategoryByDiscount = categoryServiceBlockingStub.getAllCategoryByDiscount(AllCategoryRequest.newBuilder().build());
        List<Category> categoryList = allCategoryByDiscount.getCategoryList();

        return AllCategoryResp.builder().
                categoryList(categoryList.stream()
                        .map(AllCategoryMapper.INSTANCE::grpcCategoryToAllCategoryDto)
                        .toList())
                .build();
    }
}
