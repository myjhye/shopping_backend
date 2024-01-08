package com.shopping.shopping.service.impl;

import com.shopping.shopping.dto.ProductsDto;
import com.shopping.shopping.entity.Products;
import com.shopping.shopping.exception.ResourceNotFoundException;
import com.shopping.shopping.mapper.ProductsMapper;
import com.shopping.shopping.repository.ProductsRepository;
import com.shopping.shopping.service.ProductsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductsServiceImpl implements ProductsService {

    private ProductsRepository productsRepository;

    // 상품 등록
    @Override
    public ProductsDto createProducts(ProductsDto productsDto) {

        Products products = ProductsMapper.mapToProducts(productsDto);
        Products savedProducts = productsRepository.save(products);

        return ProductsMapper.mapToProductsDto(savedProducts);
    }

    // 상품 단일 조회
    @Override
    public ProductsDto getProductById(Long productId) {

        Products product = productsRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("상품이 존재하지 않음 : " + productId));

        return ProductsMapper.mapToProductsDto(product);
    }
}
