package com.microservice.product.model.mapper;

import com.microservice.grpc.Category;
import com.microservice.product.model.dto.AllCategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AllCategoryMapper {
    AllCategoryMapper INSTANCE = Mappers.getMapper(AllCategoryMapper.class);

    AllCategoryDto grpcCategoryToAllCategoryDto(Category category);
}
