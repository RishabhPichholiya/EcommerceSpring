package com.example.EcommerceSpring.gateway;

import com.example.EcommerceSpring.dto.ProductDTO;

import java.io.IOException;
import java.util.List;

public interface IProductGateway {

    List<ProductDTO> getAllProducts() throws IOException;

    ProductDTO getProduct(int id) throws IOException;
}
