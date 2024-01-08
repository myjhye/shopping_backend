package com.shopping.shopping.mapper;

import com.shopping.shopping.dto.ProductsDto;
import com.shopping.shopping.entity.Products;

public class ProductsMapper {

    public static ProductsDto mapToProductsDto(Products products) {
        return new ProductsDto(
                products.getId(),
                products.getCategory(),
                products.getImage(),
                products.getTitle(),
                products.getDescription(),
                products.getPrice(),
                products.getGender(),
                products.getOptions(),
                products.getDate()
        );
    }

    public static Products mapToProducts(ProductsDto productsDto) {
        return new Products(
                productsDto.getId(),
                productsDto.getCategory(),
                productsDto.getImage(),
                productsDto.getTitle(),
                productsDto.getDescription(),
                productsDto.getPrice(),
                productsDto.getGender(),
                productsDto.getOptions(),
                productsDto.getDate()
        );
    }
}
