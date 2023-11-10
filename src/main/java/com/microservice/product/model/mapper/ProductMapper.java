package com.microservice.product.model.mapper;


import com.microservice.product.model.Product;
import com.microservice.product.model.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

        ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
        @Mapping(target = "category.id", source = "category.id")
        ProductDto productToProductDTO(Product product);

        Product productDTOToProduct(ProductDto productDto);



    }


