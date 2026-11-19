package com.example.EcommerceSpring.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private long id;
    private String title;
    private double price;
    private String category;

}
