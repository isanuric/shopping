package com.prismaplaza.shopping.controller;

import com.prismaplaza.shopping.dto.UserProductDTO;
import com.prismaplaza.shopping.repository.ProductRepositoryExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductRepositoryExtension productRepositoryExtension;

    public ProductController(ProductRepositoryExtension productRepositoryExtension) {
        this.productRepositoryExtension = productRepositoryExtension;
    }

    /**
     * Call off all products that have less than 10 items in stock.
     */
    @GetMapping("/quantity/less-than-ten")
    public ResponseEntity<List<Object[]>> productsQuantityLessThan10() {
        List<Object[]> allProductsQuantityLessThan10 = productRepositoryExtension.findAllProductsQuantityLessThan10();

        allProductsQuantityLessThan10.stream().forEach(System.out::println);
        return ResponseEntity.ok(allProductsQuantityLessThan10);
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

        List<UserProductDTO> productList = productRepositoryExtension.findAllProductsWithQuantityLessThan(quantityThreshold);

        System.out.println("**** ****");
        productList.stream()
                .map(UserProductDTO::getName)
                .forEach(System.out::println);

        return productList;
    }


}
