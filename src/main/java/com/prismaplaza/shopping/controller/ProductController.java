package com.prismaplaza.shopping.controller;

import com.prismaplaza.shopping.repository.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/less-than-ten")
    public List<Object[]> llProductsQuantityLessThan10() {
        return productRepository.findAllProductsQuantityLessThan10();
    }
}
