package com.example.EcommerceSpring.controllers;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.dto.ProductDTO01;
import com.example.EcommerceSpring.dto.ProductWithCategoryDTO01;
import com.example.EcommerceSpring.exception.ProductNotFoundException;
import com.example.EcommerceSpring.services.IProductService01;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController01 {

    private final IProductService01 productService01;

    //create product
    @PostMapping
    public ResponseEntity<ProductDTO01> createProduct(@RequestBody ProductDTO01 dto) throws Exception{
        return ResponseEntity.ok(productService01.createProduct(dto));
    }

    // Get Products by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO01> getProductById(@PathVariable long id ) throws Exception {
        ProductDTO01 product = productService01.getProductById(id);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(product);
    }

    // Delete Products by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<ProductDTO01> deleteProductById(@PathVariable long id ) throws Exception {
        ProductDTO01 product = productService01.deleteProductById(id);
        return ResponseEntity
                .ok(product);
    }

    // Get Products by ID
    @GetMapping()
    public ResponseEntity<List<ProductDTO01>> getAllProducts( )  {
        List<ProductDTO01> product = productService01.getAllProducts();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(product);
    }

    // Get Expensive Products
    @GetMapping("/expensive")
    public ResponseEntity<List<ProductDTO01>> getExpensiveProducts(@RequestParam int minPrice ) throws Exception{
        List<ProductDTO01> product =productService01.getExpensiveProducts(minPrice);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(product);
    }

    // Get Products by keyword --> explore more current code not working
    @GetMapping("/keyword")
    public ResponseEntity<?> getProductByKeyword(@RequestParam String keyword ) throws Exception{
        try{
            List<ProductDTO01> product = productService01.findProductsByText(keyword);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(product);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found with given details");
        }

    }

    // Get Products by ID
    @GetMapping("withCategory/{id}")
    public ResponseEntity<ProductWithCategoryDTO01> findProductWithCategoryById(@PathVariable long id ) throws Exception {
        ProductWithCategoryDTO01 product = productService01.findProductWithCategoryById(id);
        return ResponseEntity
                .ok(product);
    }

}
