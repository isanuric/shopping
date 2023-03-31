package com.prismaplaza.shopping.repository;

import com.prismaplaza.shopping.dto.UserProductDTO;
import com.prismaplaza.shopping.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p.product_id, p.name FROM products p WHERE p.quantity < :quantityThreshold", nativeQuery = true)
    List<Object[]> findAllProductsWithQuantityLessThanQuery(@Param("quantityThreshold") int quantityThreshold);

    @Query(value = "SELECT p.product_id, p.name FROM products p WHERE p.quantity < :quantityThreshold", nativeQuery = true)
    Page<Object[]> findAllProductsWithQuantityLessThanQuery(@Param("quantityThreshold") int quantityThreshold, Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT product_id, p.name FROM products p WHERE quantity < 10;")
    List<Object[]> findAllProductsQuantityLessThan10();

    @Query("SELECT new com.prismaplaza.shopping.dto.UserProductDTO(p.id, p.name) FROM Product p WHERE p.quantity < :quantityThreshold")
    List<UserProductDTO> findAllProductsWithQuantityLessThanPath(@Param("quantityThreshold") int quantityThreshold);

}
