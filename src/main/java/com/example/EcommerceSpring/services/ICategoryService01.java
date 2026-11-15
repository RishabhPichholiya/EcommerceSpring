package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.CategoryDTO01;
import com.example.EcommerceSpring.dto.CategoryWithProductDTO01;
import com.example.EcommerceSpring.dto.ProductDTO01;

import java.io.IOException;
import java.util.List;

public interface ICategoryService01 {

    CategoryDTO01 createCategory(CategoryDTO01 dto) throws Exception;

    List<CategoryDTO01> getAllCategories() throws IOException;

    CategoryDTO01 getByName(String name) throws Exception;

    CategoryWithProductDTO01 getCategoryWithProductById(Long id) throws Exception;
}
