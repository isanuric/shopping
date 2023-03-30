package com.prismaplaza.shopping.repository;

public class ProductRepositoryTest {

//    @Test
//    void testFindAllProductIdsWithQuantityLessThan_cache() {
//        int quantityThreshold = 80;
//
//        // Clear cache
//        cacheManager.getCache("productCache").clear();
//        assertNull(cacheManager.getCache("productCache").get("find", List.class));
//
//        // First call should not come from cache
//        List<UserProductDTO> result1 = productService.findAllProductsWithQuantityLessThan(quantityThreshold);
//        assertTrue(result1.size() > 0);
//
//        // Second call should come from cache
//        List<UserProductDTO> result2 = productService.findAllProductsWithQuantityLessThan(quantityThreshold);
//        assertEquals(result1, result2);
//
//        // Check that result is in cache
//        Cache productCache = cacheManager.getCache("productCache");
//        List<UserProductDTO> cachedResult = productCache.get("findAllProductsWithQuantityLessThanKey", List.class);
//        assertEquals(result2, cachedResult);
//    }


}
