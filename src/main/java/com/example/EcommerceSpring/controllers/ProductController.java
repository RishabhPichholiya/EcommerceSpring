package com.example.EcommerceSpring.controllers;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.services.IProductService;
import com.example.EcommerceSpring.services.IProductService01;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class ProductController {



    private final IProductService productService;

    // Get All Products
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllCategories() throws IOException {

        return ResponseEntity.ok(productService.getAllProduct());
    }

    // Get Products by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable int id ) throws IOException{
        ProductDTO product = productService.getProduct(id);
        return ResponseEntity
            .status(HttpStatus.CREATED)
                .body(product);
    }

}
