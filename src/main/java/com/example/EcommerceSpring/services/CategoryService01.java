package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.CategoryDTO01;
import com.example.EcommerceSpring.entity.Category;
import com.example.EcommerceSpring.mapper.CategoryMapper;
import com.example.EcommerceSpring.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService01 implements ICategoryService01{

    private final CategoryRepository categoryRepository;
    @Override
    public CategoryDTO01 createCategory(CategoryDTO01 dto) throws Exception {
        Category category =categoryRepository.save(CategoryMapper.toEntity(dto));
        return CategoryMapper.toDto(category);
    }

    @Override
    public List<CategoryDTO01> getAllCategories() throws IOException {
        List<CategoryDTO01> result =categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::toDto)
                .collect(Collectors.toList())
                ;
        return result;
    }

    @Override
    public CategoryDTO01 getByName(String name) throws Exception {
        Category category =categoryRepository.findByName(name)
                .orElseThrow(() -> new Exception("Category not found with name: " +name));
        return CategoryMapper.toDto(category);
    }
}
