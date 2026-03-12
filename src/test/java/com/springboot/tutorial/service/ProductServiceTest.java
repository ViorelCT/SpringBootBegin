package com.springboot.tutorial.service;

import com.springboot.tutorial.model.Product;
import com.springboot.tutorial.exception.ProductNotFoundException;
import com.springboot.tutorial.repository.ProductRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductService service;

    @Test
    void shouldReturnProductById() {

        Product product = new Product(1L, "Laptop", 5000);

        when(repository.findById(1L))
                .thenReturn(Optional.of(product));

        Product result = service.getProductById(1L);

        assertEquals("Laptop", result.getName());

        verify(repository).findById(1L);
    }

    @Test
    void shouldThrowExceptionWhenProductNotFound() {

        when(repository.findById(1L))
                .thenReturn(Optional.empty());

        assertThrows(ProductNotFoundException.class, () ->
                service.getProductById(1L)
        );
    }

    @Test
    void shouldAddProduct() {

        Product product = new Product(1L, "Laptop", 5000);

        when(repository.findById(1L))
                .thenReturn(Optional.empty());

        when(repository.save(product))
                .thenReturn(product);

        Product saved = service.addProduct(product);

        assertEquals("Laptop", saved.getName());

        verify(repository).save(product);
    }

    @Test
    void shouldDeleteProduct() {

        Product product = new Product(1L, "Laptop", 5000);

        when(repository.findById(1L))
                .thenReturn(Optional.of(product));

        service.deleteProduct(1L);

        verify(repository).deleteById(1L);
    }

    @Test
    void shouldReturnAllProducts() {

        List<Product> products = List.of(
                new Product(1L,"Laptop",5000),
                new Product(2L,"Mouse",200)
        );

        when(repository.findAll())
                .thenReturn(products);

        List<Product> result = service.getAllProducts();

        assertEquals(2, result.size());
    }

}