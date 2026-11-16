package com.example.EcommerceSpring.controllers;

import com.example.EcommerceSpring.dto.CategoryDTO01;
import com.example.EcommerceSpring.dto.CategoryWithProductDTO01;
import com.example.EcommerceSpring.dto.ProductWithCategoryDTO01;
import com.example.EcommerceSpring.entity.Category;
import com.example.EcommerceSpring.exception.CategoryNotFoundException;
import com.example.EcommerceSpring.exception.ProductNotFoundException;
import com.example.EcommerceSpring.services.ICategoryService01;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product/category")
@RequiredArgsConstructor
public class CategoryController01 {

    private final ICategoryService01 categoryService01;

    //create category
    @PostMapping
    public ResponseEntity<CategoryDTO01> createCategory(@RequestBody CategoryDTO01 dto) throws Exception{
        return ResponseEntity.ok(categoryService01.createCategory(dto));
    }

    @GetMapping
    public ResponseEntity<?> getAllCategories(@RequestParam(required = false) String name) throws Exception{
        if(name != null && !name.isBlank()){
            CategoryDTO01 categoryDTO01 =categoryService01.getByName(name);
            return ResponseEntity.ok(categoryDTO01);
        }
        else{
        List<CategoryDTO01> result = this.categoryService01.getAllCategories();
        return ResponseEntity.ok(result);}
    }

    // Get CategoryWithProduct by ID
    @GetMapping("withProduct/{id}")
    public ResponseEntity<?> getCategoryWithProductById(@PathVariable long id ) throws Exception {
        try{
            CategoryWithProductDTO01 category = categoryService01.getCategoryWithProductById(id);
            return ResponseEntity.ok(category);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Category Not Found");
        }

    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleCategoryNotFound(CategoryNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
