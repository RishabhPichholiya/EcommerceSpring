package com.example.EcommerceSpring.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Product extends BaseEntity{

    private String image;
    private String color;
    private int price;
    private String description;
    private int discount;
    private String model;
    private String title;
    private String brand;
    private boolean popular;


    // One Category may have many columns
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;

}
