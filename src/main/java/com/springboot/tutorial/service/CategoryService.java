package com.springboot.tutorial.service;

import com.springboot.tutorial.model.Category;
import com.springboot.tutorial.repository.CategoryRepository;
import com.springboot.tutorial.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    public Category createCategory(Category category) {
        return repository.save(category);
    }

    public void deleteCategory(Long id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException("Category not found");
        }

        if (repository.existsByCategoryId(id)) {
            throw new RuntimeException("Cannot delete category with existing products");
        }

        repository.deleteById(id);
    }

    public Category updateCategory(Long id, Category updated) {

        Category category = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        category.setName(updated.getName());

        return repository.save(category);
    }
}