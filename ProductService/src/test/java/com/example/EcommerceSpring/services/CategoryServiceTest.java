package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.CategoryDTO01;
import com.example.EcommerceSpring.entity.Category;
import com.example.EcommerceSpring.repository.CategoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class) //This annotation is used to enable Mockito for the test class with JUnit
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService01 categoryService01;

    @Test
    @DisplayName("should return all categories successfully")
    void getAllCategories_shouldReturnAllCategories() throws IOException {

        //Arrange
        List<Category> categories = new ArrayList<>();
        Category category1 = Category.builder().name("Electronics").build();
        category1.setId(1L);
        Category category2= Category.builder().name("Books").build();
        category2.setId(2L);
        categories.add(category1);
        categories.add(category2);
        when(categoryRepository.findAll()).thenReturn(categories); // mocked the repo to return the categories.

        //Act
        List<CategoryDTO01> result =categoryService01.getAllCategories(); //service is actually really called

        //Assert
        assertEquals(result.size(),2);
        verify(categoryRepository, times(1)).findAll();

    }

}
