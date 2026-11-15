package com.example.EcommerceSpring.repository;

import com.example.EcommerceSpring.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    // This is a custom query method using HQL. Explicitly define the query logic
    @Query("SELECT p from Product p where p.price > :minPrice")
    List<Product> findExpensiveProducts(@Param("minPrice") double minPrice);


    @Query(value = "Select * FROM product where MATCH(brand, description) AGAINST (:keyword)", nativeQuery = true)
    List<Product> searchFullText(@Param("keyword") String keyword);
}
