package com.example.EcommerceSpring.mapper;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.entity.Product;

public class ProductMapper {

    public static ProductDTO toDto(Product product){
        return ProductDTO.builder()
                .id(product.getId())
                .price(product.getPrice())
                .title(product.getTitle())
                .category(product.getCategory())
                .build();
    }

    public static Product toEntity(ProductDTO dto){
        return Product.builder()
                .price(dto.getPrice())
                .title(dto.getTitle())
                .category(dto.getCategory())
                .build();
    }
}
