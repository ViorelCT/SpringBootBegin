package com.springboot.tutorial.service;

import com.springboot.tutorial.model.Product;
import com.springboot.tutorial.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    private final Map<Long, Product> products = new HashMap<>();

    public ProductService() {

//        createProduct(new Product(null, "Laptop", 1500));
//        createProduct(new Product(null, "Phone", 800));
//        createProduct(new Product(null, "Monitor", 400));
    }

    private long nextId = 1;

    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }

    public Product getProductById(Long id) {

        return Optional.ofNullable(products.get(id))
                .orElseThrow(() ->
                        new ProductNotFoundException("Product " + id + " not found"));
    }

    public Product createProduct(Product product) {

        product.setId(nextId++);
        products.put(product.getId(), product);

        return product;
    }

    public Product updateProduct(Long id, Product updatedProduct) {

        Product product = getProductById(id);

        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());

        return product;
    }

    public void deleteProduct(Long id) {

        if(products.remove(id) == null){
            throw new ProductNotFoundException("Product " + id + " not found");
        }
        products.remove(id);
    }
}