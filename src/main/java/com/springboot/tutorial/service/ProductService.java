package com.springboot.tutorial.service;

import com.springboot.tutorial.model.Product;
import com.springboot.tutorial.exception.ProductNotFoundException;
import com.springboot.tutorial.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product addProduct(Product product) {

        if (repository.findById(product.getId()).isPresent()) {
            throw new IllegalArgumentException("Product ID already exists");
        }

        return repository.save(product);
    }

    public Product getProductById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException("Product not found"));
    }

    public List<Product> getAllProducts() {

        return repository.findAll();
    }

    public Product updateProduct(Long id, String name, double price) {

        Product product = repository.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException("Product not found"));

        product.setName(name);
        product.setPrice(price);

        return repository.save(product);
    }

    public void deleteProduct(Long id) {

        repository.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException("Product not found"));

        repository.deleteById(id);
    }

    public List<Product> getProductsAbovePrice(double price) {

        return repository.findAll()
                .stream()
                .filter(p -> p.getPrice() > price)
                .collect(Collectors.toList());
    }

    public List<String> getProductNamesByPrice(double price) {

        return repository.findAll()
                .stream()
                .filter(p -> p.getPrice() == price)
                .map(Product::getName)
                .collect(Collectors.toList());
    }
}