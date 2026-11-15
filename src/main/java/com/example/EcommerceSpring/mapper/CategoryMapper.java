package com.example.EcommerceSpring.mapper;

import com.example.EcommerceSpring.dto.CategoryDTO01;
import com.example.EcommerceSpring.dto.ProductDTO01;
import com.example.EcommerceSpring.entity.Category;
import com.example.EcommerceSpring.entity.Product;

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
}
