package com.example.EcommerceSpring.controllers;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.services.IProductService01;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController01 {

    private final IProductService01 productService01;

    //create product
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO dto){
        return ResponseEntity.ok(productService01.createProduct(dto));
    }

    // Get Products by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable long id ) throws Exception {
        ProductDTO product = productService01.getProductById(id);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(product);
    }

}
