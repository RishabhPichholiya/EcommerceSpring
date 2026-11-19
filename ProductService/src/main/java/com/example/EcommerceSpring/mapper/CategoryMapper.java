package com.example.EcommerceSpring.mapper;

import com.example.EcommerceSpring.dto.CategoryDTO01;
import com.example.EcommerceSpring.dto.CategoryWithProductDTO01;
import com.example.EcommerceSpring.dto.ProductDTO01;
import com.example.EcommerceSpring.entity.Category;
import com.example.EcommerceSpring.entity.Product;

import java.util.stream.Collectors;

public class CategoryMapper {

    public static CategoryDTO01 toDto(Category category){
        return CategoryDTO01.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public static Category toEntity(CategoryDTO01 dto){
        return Category.builder()
                .name(dto.getName())
                .build();
    }

    public static CategoryWithProductDTO01 CategoryWithProducttoDto(Category category){
        return CategoryWithProductDTO01.builder()
                .id(category.getId())
                .name(category.getName())
                .product(category.getProducts()
                        .stream()
                        .map(ProductMapper::toDto)
                        .collect(Collectors.toList()))
                .build();
    }
}
