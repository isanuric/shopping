package com.prismaplaza.shopping.controller;

import com.prismaplaza.shopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {


    @Autowired
    ProductRepository productRepository;


    @GetMapping("/less-than-ten")
    public List<Object[]> llProductsQuantityLessThan10() {
        return productRepository.findAllProductsQuantityLessThan10();
    }
}
