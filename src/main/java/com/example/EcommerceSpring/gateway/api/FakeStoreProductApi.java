package com.example.EcommerceSpring.gateway.api;

import com.example.EcommerceSpring.dto.FakeStoreProductResponseDTO;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.http.GET;

import java.io.IOException;
import java.util.List;

@Component
public interface FakeStoreProductApi {

    @GET("products")
    Call<List<FakeStoreProductResponseDTO>> getAllFakeProducts() throws IOException;
}
