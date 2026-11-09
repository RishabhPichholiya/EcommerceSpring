package com.example.EcommerceSpring.entity;


import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Product extends BaseEntity{

    private long id;
    private String title;
    private double price;
    private String category;

}
