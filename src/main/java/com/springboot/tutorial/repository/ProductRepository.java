package com.springboot.tutorial.repository;

import com.springboot.tutorial.model.Product;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p JOIN FETCH p.category")
    List<Product> findAllWithCategory();

    @Query("SELECT p FROM Product p JOIN FETCH p.category WHERE p.id = :id")
    Product findByIdWithCategory(Long id);

    boolean existsByCategoryId(Long categoryId);
}