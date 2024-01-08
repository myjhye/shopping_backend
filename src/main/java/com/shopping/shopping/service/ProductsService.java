package com.shopping.shopping.service;

import com.shopping.shopping.dto.ProductsDto;

public interface ProductsService {
    // 상품 등록
    ProductsDto createProducts(ProductsDto productsDto);

    // 상품 단일 조회
    ProductsDto getProductById(Long productId);
}
