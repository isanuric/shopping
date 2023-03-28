package com.prismaplaza.shopping.repository;

import com.prismaplaza.shopping.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM products WHERE quantity < 10;")
    List<Object[]> findAllProductsQuantityLessThan10();
}
