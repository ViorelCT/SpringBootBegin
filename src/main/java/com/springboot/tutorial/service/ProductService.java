package com.springboot.tutorial.service;

import com.springboot.tutorial.exception.ProductNotFoundException;
import com.springboot.tutorial.model.Product;
import com.springboot.tutorial.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ProductNotFoundException("Product " + id + " not found"));
    }

    public Product createProduct(Product product) {
        return repository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {

        Product product = getProductById(id);

        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());

        return repository.save(product);
    }

    public void deleteProduct(Long id) {

        if (repository.findById(id).isEmpty()) {
            throw new ProductNotFoundException("Product " + id + " not found");
        }

        repository.deleteById(id);
    }
}