package com.springboot.tutorial.service;

import com.springboot.tutorial.model.Product;
import com.springboot.tutorial.exception.ProductNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private ProductService service;

    @BeforeEach
    void setUp() {
        service = new ProductService();
    }

    @Test
    void shouldReturnProductById() {
        Product product = new Product(null, "Laptop", 5000);
        Product created = service.createProduct(product);

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
        Product saved = service.createProduct(product);

        assertNotNull(saved.getId());
        assertEquals("Laptop", saved.getName());
        assertEquals(5000, saved.getPrice());

        // Confirm it's in the service storage
        Product fetched = service.getProductById(saved.getId());
        assertEquals("Laptop", fetched.getName());
    }

    @Test
    void shouldDeleteProduct() {
        Product product = new Product(null, "Laptop", 5000);
        Product created = service.createProduct(product);

        // Delete
        service.deleteProduct(created.getId());

        // Verify deletion
        assertThrows(ProductNotFoundException.class, () ->
                service.getProductById(created.getId())
        );
    }

    @Test
    void shouldReturnAllProducts() {
        Product p1 = service.createProduct(new Product(null, "Laptop", 5000));
        Product p2 = service.createProduct(new Product(null, "Mouse", 200));

        List<Product> result = service.getAllProducts();

        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(p -> p1.getName().equals("Laptop")));
        assertTrue(result.stream().anyMatch(p -> p2.getName().equals("Mouse")));
    }

    @Test
    void shouldUpdateProduct() {
        // Arrange: create initial product
        Product product = new Product(null, "Laptop", 5000);
        Product created = service.createProduct(product);

        // Prepare update data
        Product updateData = new Product(null, "Gaming Laptop", 7000);

        // Act: update product
        Product updated = service.updateProduct(created.getId(), updateData);

        // Assert: check all fields
        assertEquals(created.getId(), updated.getId(), "ID should remain the same");
        assertEquals("Gaming Laptop", updated.getName(), "Name should be updated");
        assertEquals(7000, updated.getPrice(), "Price should be updated");

        // Confirm storage updated
        Product fetched = service.getProductById(created.getId());
        assertEquals("Gaming Laptop", fetched.getName());
        assertEquals(7000, fetched.getPrice());
    }
}