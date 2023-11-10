package com.microservice.product.service.impl;


import com.microservice.product.model.Category;
import com.microservice.product.model.dto.CategoryAddRequest;
import com.microservice.product.model.dto.CategoryAddResponse;
import com.microservice.product.model.dto.CategoryDto;
import com.microservice.product.model.mapper.CategoryMapper;
import com.microservice.product.repository.CategoryRepository;
import com.microservice.product.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public CategoryAddResponse categoryAdd(CategoryAddRequest categoryAddRequest) {
        CategoryDto categoryDto = categoryAddRequest.getCategoryDto();
        Category category = CategoryMapper.INSTANCE.categoryDTOToCategory(categoryDto);
        Category responseCategory = categoryRepository.save(category);
        CategoryDto responseCategoryDTO = CategoryMapper.INSTANCE.categoryToCategoryDTO(responseCategory);
        return CategoryAddResponse.builder().categoryDto(responseCategoryDTO).build();
    }
}
