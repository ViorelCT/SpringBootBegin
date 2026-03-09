package com.mavendemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductService {
    private final Map<Long, Product> products = new HashMap<>();

    public void addProduct(Product product) {

        if (products.containsKey(product.getId())) {
            throw new IllegalArgumentException("Product ID already exists");
        }

        products.put(product.getId(), product);
    }

    public Product getProductById(Long id) {

        Product product = products.get(id);

        if (product == null) {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }

        return product;
    }

    public String getProductNameByID(Long id) {
        Product product = products.get(id);
        if (product == null) {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }
        return product.getName();
    }

    public void deleteProduct(Long id) {

        if (!products.containsKey(id)) {
            throw new ProductNotFoundException("Cannot delete. Product not found.");
        }

        products.remove(id);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    public List<Product> getProductsAbovePrice(double price) {

        return products.values().stream()
                .filter(p -> p.getPrice() > price)
                .collect(Collectors.toList());
    }

    public List<String> getProductNamesByPrice(double price) {

        return products.values()
                .stream()
                .filter(product -> product.getPrice() == price)
                .map(Product::getName)
                .toList();
    }
}
