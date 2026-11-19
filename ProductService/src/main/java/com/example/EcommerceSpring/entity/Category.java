package com.example.EcommerceSpring.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    // One Category can have multiple products
    // This does not mean that you are trying to store a list of products inside category table.
    // Telling JPA, the relationship is already owned by the product entity. So, just read from there.
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Product> products;
}
