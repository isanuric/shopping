package com.prismaplaza.shopping.repository;

import com.prismaplaza.shopping.dto.UserProductDTO;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.stream.Collectors;

public interface ProductRepositoryExtension extends ProductRepository {


    @Cacheable(value = "productCache", key = "'findAllProductsWithQuantityLessThanKey'")
    default List<UserProductDTO> findAllProductsWithQuantityLessThan(int quantityThreshold) {
        return findAllProductsWithQuantityLessThanQuery(quantityThreshold).stream()
                .parallel()
                .map(row -> UserProductDTO.builder()
                        .productId((Integer) row[0]).name((String) row[1]).build())
                .collect(Collectors.toList());
    }
}
