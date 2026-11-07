package com.example.EcommerceSpring.gateway;

import com.example.EcommerceSpring.dto.FakeStoreProductResponseDTO;
import com.example.EcommerceSpring.dto.ProductDTO;
import com.example.EcommerceSpring.gateway.api.FakeStoreProductApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FakeStoreProductGateway implements IProductGateway {

    private  final FakeStoreProductApi fakeStoreProductApi;
    @Override
    public List<ProductDTO> getAllProducts() throws IOException {
        //1. Make the HTTP request to the FakeStore API to fetch all the products
        List<FakeStoreProductResponseDTO> response = this.fakeStoreProductApi.getAllFakeProducts().execute().body();
        if(response==null){
            throw new IOException("Failed to fetch products from FakeStore API");
        }
        return response.stream()
                .map(product -> ProductDTO.builder()
                        .id(product.getId())
                        .category(product.getCategory())
                        .title(product.getTitle())
                        .price(product.getPrice())
                        .build()
                ).toList();
    }
}
