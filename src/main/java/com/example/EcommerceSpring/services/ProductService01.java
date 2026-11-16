package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.dto.ProductDTO01;
import com.example.EcommerceSpring.dto.ProductWithCategoryDTO01;
import com.example.EcommerceSpring.entity.Category;
import com.example.EcommerceSpring.entity.Product;
import com.example.EcommerceSpring.exception.ProductNotFoundException;
import com.example.EcommerceSpring.mapper.ProductMapper;
import com.example.EcommerceSpring.repository.CategoryRepository;
import com.example.EcommerceSpring.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService01 implements IProductService01{

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    public ProductDTO01 getProductById(Long id) throws Exception{
        return productRepository.findById(id)
                .map(ProductMapper::toDto)
                .orElseThrow(()-> new Exception("Product not found"));
    }

    @Override
    public ProductDTO01 createProduct(ProductDTO01 dto) throws Exception{
       Category category = categoryRepository.findById(dto.getCategoryId())
               .orElseThrow(() -> new Exception("Category not found"));

        Product product =productRepository.save(ProductMapper.toEntity(dto, category));
        return ProductMapper.toDto(product);
    }

    @Override
    public ProductDTO01 updateProductById(Long id) {

        return null;
    }

    @Override
    public ProductDTO01 deleteProductById(Long id) {
        ProductDTO01 product1 = productRepository.findById(id)
                .map(ProductMapper::toDto)
                .get()
                ;
        productRepository.deleteById(id);

        return product1;
    }

    @Override
    public List<ProductDTO01> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());

    }

    @Override
    public List<ProductDTO01> getExpensiveProducts(double minPrice) throws Exception {
        List<ProductDTO01> result = productRepository.findExpensiveProducts(minPrice)
                .stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public List<ProductDTO01> findProductsByText(String keyword) throws Exception {
        List<ProductDTO01> result = productRepository.searchFullText(keyword)
                .stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public ProductWithCategoryDTO01 findProductWithCategoryById(Long id) throws Exception{
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with ID " + id +  " not found"));
        return ProductMapper.productWithCategorytoDto(product);
    }


}
