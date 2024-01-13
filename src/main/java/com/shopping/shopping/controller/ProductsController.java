package com.shopping.shopping.controller;

import com.shopping.shopping.dto.ProductsDto;
import com.shopping.shopping.service.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductsController {

    private ProductsService productsService;

    // 상품 추가 REST API (POST)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ProductsDto> createProducts(@RequestBody ProductsDto productsDto) {
        ProductsDto savedProducts = productsService.createProducts(productsDto);
        return new ResponseEntity<>(savedProducts, HttpStatus.CREATED);
    }

    // 상품 단일 조회 REST API (GET)
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("{id}")
    public ResponseEntity<ProductsDto> getProductById(@PathVariable("id") Long productId) {
        ProductsDto productsDto = productsService.getProductById(productId);
        return ResponseEntity.ok(productsDto);
    }

    // 상품 전체 조회 REST API (GET)
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<List<ProductsDto>> getAllProducts() {
        List<ProductsDto> products = productsService.getAllProducts();
        return ResponseEntity.ok(products);
    }

}
