package com.prismaplaza.shopping.integrationtest;

import com.prismaplaza.shopping.dto.UserProductDTO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Container
    static PostgreSQLContainer postgreSQLContainer = (PostgreSQLContainer) new PostgreSQLContainer("postgres:latest")
            .withUsername("testuser")
            .withPassword("testpass")
            .withDatabaseName("testdb");

    @BeforeAll
    static void beforeAll() {
        postgreSQLContainer.start();
    }

    @AfterAll
    static void afterAll() {
        postgreSQLContainer.stop();
    }

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
