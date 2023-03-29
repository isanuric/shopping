package com.prismaplaza.shopping.controller;

import com.prismaplaza.shopping.dto.UserProductDTO;
import com.prismaplaza.shopping.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Call off all products that have less than 10 items in stock.
     */
    @GetMapping("/less-than-ten")
    public List<Object[]> productsQuantityLessThan10() {
        return productRepository.findAllProductsQuantityLessThan10();
    }

    @GetMapping("/quantity/{quantityThreshold}")
    public List<UserProductDTO> allProductsQuantityLessThan(@PathVariable int quantityThreshold) {

        //        List<Object[]> productObjects = productRepository.findAllProductIdsWithQuantityLessThanQuery01(quantityThreshold);
        //        List<Map<String, Object>> products = new ArrayList<>();
        //        for (Object[] productObject : productObjects) {
        //            Map<String, Object> productMap = new HashMap<>();
        //            productMap.put("productId", productObject[0]);
        //            productMap.put("name", productObject[1]);
        //            products.add(productMap);
        //        }
        //        return products;

        return productRepository.findAllProductIdsWithQuantityLessThan01(quantityThreshold);
    }

}
