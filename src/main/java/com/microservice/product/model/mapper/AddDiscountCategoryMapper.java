package com.microservice.product.model.mapper;

import com.microservice.product.model.dto.AddDiscountCategoryRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddDiscountCategoryMapper {

    AddDiscountCategoryMapper INSTANCE = Mappers.getMapper(AddDiscountCategoryMapper.class);

    com.microservice.grpc.AddDiscountCategoryRequest addDiscountCategoryRequestToGrpcAddDiscountCategoryRequest(AddDiscountCategoryRequest addDiscountCategoryRequest);


}
