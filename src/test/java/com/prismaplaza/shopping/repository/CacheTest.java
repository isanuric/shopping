package com.prismaplaza.shopping.repository;

import com.prismaplaza.shopping.dto.UserProductDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class CacheTest {

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private ProductRepositoryExtension productRepositoryExtension;

    @Test
    void testFindAllProductIdsWithQuantityLessThan_cache() {
        int quantityThreshold = 80;

        // Clear cache
        cacheManager.getCache("productCache").clear();
        assertNull(cacheManager.getCache("productCache").get("find", List.class));

        // First call should not come from cache
        List<UserProductDTO> result1 = productRepositoryExtension.findAllProductsWithQuantityLessThan(quantityThreshold);
        assertTrue(result1.size() > 0);

        // Second call should come from cache
        List<UserProductDTO> result2 = productRepositoryExtension.findAllProductsWithQuantityLessThan(quantityThreshold);
        assertEquals(result1, result2);

        // Check that result is in cache
        Cache productCache = cacheManager.getCache("productCache");
        List<UserProductDTO> cachedResult = productCache.get("findAllProductsWithQuantityLessThanKey", List.class);
        assertEquals(result2, cachedResult);
    }

}
