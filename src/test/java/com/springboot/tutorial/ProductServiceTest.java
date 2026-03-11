package com.springboot.tutorial;

import com.springboot.tutorial.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    void setup() {
        productService = new ProductService();
    }

    @Test
    void testCreateProduct() {

        Product product = new Product(1L, "Laptop", 3500);

        Product savedProduct = productService.addProduct(product);

        assertNotNull(savedProduct);
        assertEquals("Laptop", savedProduct.getName());
    }

    @Test
    void testReturnProductByID() {

        Product product = new Product(1L, "Monitor", 1500);
        productService.addProduct(product);

        Product resultName = productService.getProductById(1L);;

        assertNotNull(resultName);
        assertEquals(1500, resultName.getPrice());
        assertEquals("Monitor", resultName.getName());
    }

    @Test
    void testReturnAllProducts() {

        productService.addProduct(new Product(1L, "Monitor", 2000));
        productService.addProduct(new Product(2L, "Phone", 1000));

        List<Product> products = productService.getAllProducts();

        assertEquals(2, products.size());
    }

    @Test
    void testUpdateProduc() {

        productService.addProduct(new Product(1L, "Monitor", 2500));
        productService.addProduct(new Product(2L, "Phone", 1500));

        Product update = productService.updateProduct(2L, "Mouse", 200);

        assertEquals("Mouse", update.getName());
        assertEquals(200, update.getPrice());
    }

}
