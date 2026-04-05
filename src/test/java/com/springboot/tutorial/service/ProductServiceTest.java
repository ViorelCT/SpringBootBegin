package com.springboot.tutorial.service;

import com.springboot.tutorial.exception.ProductNotFoundException;
import com.springboot.tutorial.model.Product;
import com.springboot.tutorial.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ProductServiceTest {

    @Autowired
    private ProductService service;

    @Autowired
    private ProductRepository repository;

    @BeforeEach
    void cleanDatabase() {
        repository.deleteAll();
    }

    @Test
    void shouldReturnProductById() {
        Product product = new Product(null, "Laptop", 5000);
        Product created = service.createProduct(product, 1L);

        Product result = service.getProductById(created.getId());

        assertEquals("Laptop", result.getName());
        assertEquals(5000, result.getPrice());
    }

    @Test
    void shouldThrowExceptionWhenProductNotFound() {
        assertThrows(ProductNotFoundException.class, () ->
                service.getProductById(999L)
        );
    }

    @Test
    void shouldAddProduct() {
        Product product = new Product(null, "Laptop", 5000);
        Product saved = service.createProduct(product, 1L);

        assertNotNull(saved.getId());
        assertEquals("Laptop", saved.getName());
        assertEquals(5000, saved.getPrice());

        Product fetched = service.getProductById(saved.getId());
        assertEquals("Laptop", fetched.getName());
    }

    @Test
    void shouldDeleteProduct() {
        Product product = new Product(null, "Laptop", 5000);
        Product created = service.createProduct(product, 1L);

        service.deleteProduct(created.getId());

        assertThrows(ProductNotFoundException.class, () ->
                service.getProductById(created.getId())
        );
    }

    @Test
    void shouldReturnAllProducts() {
        Product p1 = service.createProduct(new Product(null, "Laptop", 5000), 1L);
        Product p2 = service.createProduct(new Product(null, "Mouse", 200), 1L);

        List<Product> result = service.getAllProducts();

        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(p -> p.getName().equals("Laptop")));
        assertTrue(result.stream().anyMatch(p -> p.getName().equals("Mouse")));
    }

    @Test
    void shouldUpdateProduct() {
        Product product = new Product(null, "Laptop", 5000);
        Product created = service.createProduct(product, 1L);

        Product updateData = new Product(null, "Gaming Laptop", 7000);

        Product updated = service.updateProduct(created.getId(), updateData, 1L);

        assertEquals(created.getId(), updated.getId());
        assertEquals("Gaming Laptop", updated.getName());
        assertEquals(7000, updated.getPrice());

        Product fetched = service.getProductById(created.getId());
        assertEquals("Gaming Laptop", fetched.getName());
        assertEquals(7000, fetched.getPrice());
    }
}