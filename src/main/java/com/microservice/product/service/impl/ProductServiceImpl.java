package com.microservice.product.service.impl;


import com.microservice.product.model.Product;
import com.microservice.product.model.dto.ProductAddRequest;
import com.microservice.product.model.dto.ProductAddResponse;
import com.microservice.product.model.dto.ProductDto;
import com.microservice.product.model.dto.ProductListResponse;
import com.microservice.product.model.mapper.ProductMapper;
import com.microservice.product.repository.ProductRepository;
import com.microservice.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public ProductAddResponse productAdd(ProductAddRequest productAddRequest) {
        ProductDto productDto = productAddRequest.getProductDto();
        Product product = ProductMapper.INSTANCE.productDTOToProduct(productDto);
        Product responseProduct = productRepository.save(product);
        ProductDto responseProductDto = ProductMapper.INSTANCE.productToProductDTO(responseProduct);
        return ProductAddResponse.builder().productDto(responseProductDto).build();
    }

    @Override
    public ProductListResponse getAllProduct() {

        List<ProductDto> productDtoList = productRepository.findAll().stream()
                .map(ProductMapper.INSTANCE::productToProductDTO)
                .collect(Collectors.toList());

        return ProductListResponse.builder()
                .productDtoList(productDtoList)
                .build();
    }
}
