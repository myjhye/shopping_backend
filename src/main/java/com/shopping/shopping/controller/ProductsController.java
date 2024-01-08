package com.shopping.shopping.controller;

import com.shopping.shopping.dto.ProductsDto;
import com.shopping.shopping.service.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private ProductsService productsService;

    // 상품 추가 REST API (POST)
    @PostMapping
    public ResponseEntity<ProductsDto> createProducts(@RequestBody ProductsDto productsDto) {
        ProductsDto savedProducts = productsService.createProducts(productsDto);
        return new ResponseEntity<>(savedProducts, HttpStatus.CREATED);
    }

    // 상품 단일 조회 REST API (GET)
    @GetMapping("{id}")
    public ResponseEntity<ProductsDto> getProductById(@PathVariable("id") Long productId) {
        ProductsDto productsDto = productsService.getProductById(productId);
        return ResponseEntity.ok(productsDto);
    }

}
