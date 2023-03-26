//package com.prismaplaza.shopping.entity;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//import java.util.List;
//
//
//@Entity
//@Table(name = "products")
//@Data
//public class Product {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    private String name;
//
//    @Column(nullable = false)
//    private String description;
//
//    @Column(nullable = false)
//    private Double price;
//
//    @Column(nullable = false)
//    private Integer stock;
//
//    @OneToMany(mappedBy = "product")
//    private List<OrderItem> orderItems;
//
//}
