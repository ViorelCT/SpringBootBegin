package com.springboot.tutorial.repository;

import com.springboot.tutorial.model.Product;

import java.util.*;

public class InMemoryProductRepository implements ProductRepository {

    private final Map<Long, Product> products = new HashMap<>();

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public Product save(Product product) {

        products.put(product.getId(), product);

        return product;
    }

    @Override
    public void deleteById(Long id) {

        products.remove(id);
    }
}