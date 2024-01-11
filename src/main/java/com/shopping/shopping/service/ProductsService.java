package com.shopping.shopping.service;

import com.shopping.shopping.dto.ProductsDto;

import java.util.List;

public interface ProductsService {
    // 상품 등록
    ProductsDto createProducts(ProductsDto productsDto);

    // 상품 단일 조회
    ProductsDto getProductById(Long productId);

    // 상품 전체 조회
    List<ProductsDto> getAllProducts();
}
