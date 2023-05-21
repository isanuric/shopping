package com.prismaplaza.shopping.repository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@TestPropertySource(locations="classpath:application-test-in-memory.properties")
@Sql({"/schema.sql", "/data.sql"})
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ProductRepositoryExtensionTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testFindAllProductsWithQuantityLessThanQuery() {
        int quantityThreshold = 50;
        List<Object[]> products = productRepository.findAllProductsWithQuantityLessThanQuery(quantityThreshold);
        assertNotNull(products);
        assertTrue(products.size() > 0);
    }

    @Test
    public void testFindAllProductsWithQuantityLessThanQueryPaged() {
        int quantityThreshold = 50;
        Pageable pageable = PageRequest.of(0, 10);
        Page<Object[]> productsPage = productRepository.findAllProductsWithQuantityLessThanQuery(quantityThreshold, pageable);
        assertNotNull(productsPage);
        assertTrue(productsPage.getTotalElements() > 0);
    }

    @Test
    public void testFindAllProductsQuantityLessThan10() {
        List<Object[]> products = productRepository.findAllProductsQuantityLessThan10();
        assertNotNull(products);
        assertTrue(products.size() == 0);
    }

}