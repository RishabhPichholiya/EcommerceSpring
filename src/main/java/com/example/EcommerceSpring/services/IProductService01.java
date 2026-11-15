package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.ProductDTO01;
import com.example.EcommerceSpring.dto.ProductWithCategoryDTO01;

import java.util.List;

public interface IProductService01 {

    ProductDTO01 getProductById(Long id) throws Exception;

    ProductDTO01 createProduct(ProductDTO01 dto) throws Exception;

    ProductDTO01 updateProductById(Long id);

    ProductDTO01 deleteProductById(Long id);

    List<ProductDTO01> getAllProducts();

    List<ProductDTO01> getExpensiveProducts(double minPrice) throws Exception;

    List<ProductDTO01> findProductsByText(String keyword) throws Exception;

    ProductWithCategoryDTO01 findProductWithCategoryById(Long id) throws Exception;


}
