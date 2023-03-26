package com.prismaplaza.shopping.repository;

import com.prismaplaza.shopping.entity.Product;
import com.prismaplaza.shopping.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Product, Long> {

    List<Product> findByUserOrderByOrderDateDesc(User user);
}
