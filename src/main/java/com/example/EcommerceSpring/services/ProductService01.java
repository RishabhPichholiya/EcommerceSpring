package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.entity.Product;
import com.example.EcommerceSpring.mapper.ProductMapper;
import com.example.EcommerceSpring.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService01 implements IProductService01{

    private final ProductRepository productRepository;

    public ProductDTO getProductById(Long id) throws Exception{
        return productRepository.findById(id)
                .map(ProductMapper::toDto)
                .orElseThrow(()-> new Exception("Product not found"));
    }

    @Override
    public ProductDTO createProduct(ProductDTO dto) {
        Product product =productRepository.save(ProductMapper.toEntity(dto));
        return ProductMapper.toDto(product);
    }


}
