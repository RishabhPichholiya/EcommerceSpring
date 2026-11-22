package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.CategoryDTO01;
import com.example.EcommerceSpring.entity.Category;
import com.example.EcommerceSpring.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class) //This annotation is used to enable Mockito for the test class with JUnit
public class CategoryServiceTest {

    private CategoryDTO01 categoryDTO01;
    private Category category1;
    private Category category2;

    @BeforeEach
    void setUp(){
        categoryDTO01 =CategoryDTO01.builder().name("Electronics").build();
        category1 =Category.builder().name("Electronics").build();
        category1.setId(1L);
        category2 =Category.builder().name("Books").build();
        category2.setId(2L);
    }

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService01 categoryService01;

    @Test
    @DisplayName("should return all categories successfully")
    void getAllCategories_shouldReturnAllCategories() throws IOException {

        //Arrange
        List<Category> categories = new ArrayList<>();
        categories.add(category1);
        categories.add(category2);
        when(categoryRepository.findAll()).thenReturn(categories); // mocked the repo to return the categories.

        //Act
        List<CategoryDTO01> result =categoryService01.getAllCategories(); //service is actually really called

        //Assert
        assertEquals(result.size(),2);
        verify(categoryRepository, times(1)).findAll();

    }

    @Test
    @DisplayName("should create the category")
    void createCategory_shouldCreateCategory() throws Exception {

        // Arrange
        CategoryDTO01 categoryDTO= CategoryDTO01.builder().name("Electronics").build();
        Category category1 =Category.builder().name("Electronics").build();
        category1.setId(1L);
        when(categoryRepository.save(any(Category.class))).thenReturn(category1);


        //Act
        CategoryDTO01 category= categoryService01.createCategory(categoryDTO); //

        //Assert
        assertEquals("Electronics", category.getName());
    }

    @Test
    @DisplayName("Should return empty list when no categories exist")
    void getAllCategories_shouldReturnEmptyListWhenNoCategoriesExist() throws IOException{

        //Arrange
        when(categoryRepository.findAll()).thenReturn(new ArrayList<>());

        //Act
        List<CategoryDTO01> result = categoryService01.getAllCategories();

        //Assert
        assertEquals(result.size(), 0);
        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    @DisplayName("should return categories by name")
    void getByName_shouldReturnCategoryByName() throws Exception {

        //Arrange
        when(categoryRepository.findByName("Electronics")).thenReturn(Optional.of(category1));

        //Act
        CategoryDTO01 result = categoryService01.getByName("Electronics");

        //Assert
        assertEquals(result.getName(), "Electronics");
        verify(categoryRepository, times(1)).findByName("Electronics");
    }

}
