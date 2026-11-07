package com.example.EcommerceSpring.controllers;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.services.IProductService;
import lombok.RequiredArgsConstructor;
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
    public List<ProductDTO> getAllCategories() throws IOException {

        return productService.getAllProduct();
    }

    // Get Products by ID
    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable int id ) throws IOException{
        return productService.getProduct(id);
    }



}
