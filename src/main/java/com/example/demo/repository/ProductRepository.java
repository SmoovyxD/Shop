package com.example.demo.repository;


import com.example.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository interface for Product entity.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.name = :name")
    List<Product> getProductsByName(String name);

    @Query("SELECT p FROM Product p WHERE p.id IN :ids")
    List<Product> findAllByIdIn(List<Long> ids);
    @Query("SELECT p FROM Product p WHERE p.category.id = :categoryId")
    List<Product> findByCategoryId(Long categoryId);

}