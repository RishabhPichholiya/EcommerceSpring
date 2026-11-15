package com.example.EcommerceSpring.mapper;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.dto.ProductDTO01;
import com.example.EcommerceSpring.dto.ProductWithCategoryDTO01;
import com.example.EcommerceSpring.entity.Category;
import com.example.EcommerceSpring.entity.Product;

public class ProductMapper {

    public static ProductDTO01 toDto(Product product){
        return ProductDTO01.builder()
                .id(product.getId())
                .image(product.getImage())
                .color(product.getColor())
                .price(product.getPrice())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .model(product.getModel())
                .title(product.getTitle())
                .categoryId(product.getCategory().getId())
                .brand(product.getBrand())
                .popular(product.isPopular())
                .build();
    }

    public static Product toEntity(ProductDTO01 dto, Category category){
        return Product.builder()
                .image(dto.getImage())
                .color(dto.getColor())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .discount(dto.getDiscount())
                .model(dto.getModel())
                .title(dto.getTitle())
                .category(category)
                .brand(dto.getBrand())
                .popular(dto.isPopular())
                .build();
    }

    public static ProductWithCategoryDTO01 productWithCategorytoDto(Product product){
        return ProductWithCategoryDTO01.builder()
                .id(product.getId())
                .image(product.getImage())
                .color(product.getColor())
                .price(product.getPrice())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .model(product.getModel())
                .title(product.getTitle())
                .category(CategoryMapper.toDto(product.getCategory()))
                .brand(product.getBrand())
                .popular(product.isPopular())
                .build();
    }
}
