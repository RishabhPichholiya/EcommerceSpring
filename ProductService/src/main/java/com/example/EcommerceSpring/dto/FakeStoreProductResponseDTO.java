package com.example.EcommerceSpring.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FakeStoreProductResponseDTO {

    private int id;

    private String title;

    private double price;

    private String category;

    private String description;



}
