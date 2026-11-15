package com.example.EcommerceSpring.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CategoryWithProductDTO01 {
    private Long id;
    private String name;

    private List<ProductDTO01> product;
}
