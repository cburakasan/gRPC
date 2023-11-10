package com.microservice.product.model.mapper;


import com.microservice.product.model.Category;
import com.microservice.product.model.dto.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDto categoryToCategoryDTO(Category category);
    Category categoryDTOToCategory(CategoryDto categoryDto);

}
