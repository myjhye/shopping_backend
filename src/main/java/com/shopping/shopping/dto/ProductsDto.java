package com.shopping.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductsDto {
    private long id;
    private String category;
    private String image;
    private String title;
    private String description;
    private double price;
    private String gender;
    private String options;
    private String date;
}
