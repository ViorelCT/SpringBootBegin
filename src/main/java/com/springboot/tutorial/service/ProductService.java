package com.springboot.tutorial.service;

import com.springboot.tutorial.exception.ProductNotFoundException;
import com.springboot.tutorial.model.Category;
import com.springboot.tutorial.model.Product;
import com.springboot.tutorial.repository.CategoryRepository;
import com.springboot.tutorial.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository repository,
                          CategoryRepository categoryRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    public List<Product> getAllProducts() {
        return repository.findAllWithCategory();
    }

    public Product getProductById(Long id) {
        Product product = repository.findByIdWithCategory(id);
        if (product == null) {
            throw new ProductNotFoundException("Product " + id + " not found");
        }
        return product;
    }

    public Product createProduct(Product product, Long categoryId) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        product.setCategory(category);

        return repository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct, Long categoryId) {

        Product product = getProductById(id);

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());
        product.setCategory(category);

        return repository.save(product);
    }

    public void deleteProduct(Long id) {

        if (!repository.existsById(id)) {
            throw new ProductNotFoundException("Product " + id + " not found");
        }

        repository.deleteById(id);
    }
}