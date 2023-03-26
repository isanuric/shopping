package com.prismaplaza.shopping.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "products")
@Data
public class Product {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String name;

        @Column(nullable = false)
        private BigDecimal price;

        @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
        private List<Order> orders = new ArrayList<>();

}



