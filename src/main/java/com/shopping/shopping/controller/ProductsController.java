package com.shopping.shopping.controller;

import com.shopping.shopping.dto.ProductsDto;
import com.shopping.shopping.service.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private ProductsService productsService;

    // 상품 추가 REST API
    @PostMapping
    public ResponseEntity<ProductsDto> createProducts(@RequestBody ProductsDto productsDto) {
        ProductsDto savedProducts = productsService.createProducts(productsDto);
        return new ResponseEntity<>(savedProducts, HttpStatus.CREATED);
    }

}
