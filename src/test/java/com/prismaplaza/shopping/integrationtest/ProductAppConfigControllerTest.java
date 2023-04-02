package com.prismaplaza.shopping.integrationtest;

import com.prismaplaza.shopping.dto.UserProductDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-testcontainers.properties")
@Sql({"/schema.sql", "/data.sql"})
public class ProductAppConfigControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testAllProductsQuantityLessThan() {
        webTestClient.get()
                .uri("/api/products/quantity/50")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(UserProductDTO.class)
                .consumeWith(response -> {
                    List<UserProductDTO> products = response.getResponseBody();
                    assertAll(
                            () -> assertNotNull(products),
                            () -> assertEquals(6, products.size())
                    );
                });
    }

    @Test
    void testProductsQuantityLessThan10() {
//        User user = new User();
//        user.setEmail("test@test.com");
//        user.setPassword("test");
//        userRepository.save(user);

//        Product product1 = new Product();
//        product1.setName("Product 1");
//        product1.setDescription("Description 1");
//        product1.setPrice(BigDecimal.valueOf(100.00));
//        product1.setQuantity(50);
//        product1.setUser(user);

//        Product product2 = new Product();
//        product2.setName("Product 2");
//        product2.setDescription("Description 2");
//        product2.setPrice(BigDecimal.valueOf(200.00));
//        product2.setQuantity(75);
//        product2.setUser(user);
//        productRepository.saveAll(List.of(product1, product2));

        EntityExchangeResult<List<Object[]>> listEntityExchangeResult = webTestClient.get()
                .uri("/api/products/quantity/less-than-ten")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Object[].class)
                .returnResult();

        List<Object[]> products = listEntityExchangeResult.getResponseBody();
        assertNotNull(products);
    }

}
