//package com.prismaplaza.shopping.entity;
//
//import jakarta.persistence.*;
//import lombok.Data;
//
//@Entity
//@Table(name = "products")
//@Data
//public class OrderItem {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "order_id", nullable = false)
//    private Order order;
//
//    @ManyToOne
//    @JoinColumn(name = "product_id", nullable = false)
//    private Product product;
//
//    @Column(nullable = false)
//    private Integer quantity;
//
//}
