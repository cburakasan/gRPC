package com.microservice.product.controller;


import com.microservice.product.model.dto.ProductAddRequest;
import com.microservice.product.model.dto.ProductAddResponse;
import com.microservice.product.model.dto.ProductListResponse;
import com.microservice.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<ProductAddResponse> createProduct(@RequestBody ProductAddRequest productAddRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.productAdd(productAddRequest));
    }

    @GetMapping("/list")
    public ResponseEntity<ProductListResponse> getProductList() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(productService.getAllProduct());
    }
}
