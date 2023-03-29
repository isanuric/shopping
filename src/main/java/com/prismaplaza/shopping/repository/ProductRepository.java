package com.prismaplaza.shopping.repository;

import com.prismaplaza.shopping.dto.UserProductDTO;
import com.prismaplaza.shopping.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Collectors;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p.product_id, p.name FROM products p WHERE p.quantity < :quantityThreshold", nativeQuery = true)
    List<Object[]> findAllProductIdsWithQuantityLessThanQuery(@Param("quantityThreshold") int quantityThreshold);

    default List<UserProductDTO> findAllProductIdsWithQuantityLessThan01(int quantityThreshold) {
        return findAllProductIdsWithQuantityLessThanQuery(quantityThreshold).stream()
                .parallel()
                .map(row -> UserProductDTO.builder()
                        .productId((Integer) row[0]).name((String) row[1]).build())
                .collect(Collectors.toList());
    }

    @Query(nativeQuery = true, value = "SELECT p.id FROM products p WHERE quantity < 10;")
    List<Object[]> findAllProductsQuantityLessThan10();

    @Query("SELECT new com.prismaplaza.shopping.dto.UserProductDTO(p.id, p.name) FROM Product p WHERE p.quantity < :quantityThreshold")
    List<UserProductDTO> findAllProductsWithQuantityLessThan(@Param("quantityThreshold") int quantityThreshold);

}
