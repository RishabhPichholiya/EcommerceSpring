package com.example.EcommerceSpring.services;

import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.gateway.IProductGateway;
import com.example.EcommerceSpring.repository.ProductRepository;
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

    public ProductDTO getProduct(int id) throws IOException{
        return this.productGateway.getProduct(id);
    }

    @Override
    public ProductDTO deleteProduct(int id) throws IOException {
        return this.productGateway.getProduct(id);
    }
}
