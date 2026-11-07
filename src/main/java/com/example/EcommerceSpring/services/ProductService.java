package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.gateway.IProductGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final IProductGateway productGateway;

    //FETCHING ALL PRODUCTS
    @Override
    public List<ProductDTO> getAllProduct() throws IOException {

        return this.productGateway.getAllProducts();
    }
}
