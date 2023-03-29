package com.prismaplaza.shopping.dto;

import com.prismaplaza.shopping.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Builder
@AllArgsConstructor
@Data
public class UserProductDTO {

    private String userEmail;
    private String productName;

    private int productId;
    private String name;
    private String description;
    private BigDecimal price;
    private int quantity;

    private List<Product> productList;

    public UserProductDTO(String userEmail, String productName) {
        this.userEmail = userEmail;
        this.productName = productName;
    }
}
