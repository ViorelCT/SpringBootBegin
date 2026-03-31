package com.springboot.tutorial.controller;

import com.springboot.tutorial.dto.CategoryRequest;
import com.springboot.tutorial.dto.CategoryResponse;
import com.springboot.tutorial.mapper.CategoryMapper;
import com.springboot.tutorial.model.Category;
import com.springboot.tutorial.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<CategoryResponse> getAllCategories() {
        return service.getAllCategories()
                .stream()
                .map(CategoryMapper::toResponse)
                .toList();
    }

    @PostMapping
    public CategoryResponse createCategory(
            @Valid @RequestBody CategoryRequest request) {

        Category category = CategoryMapper.toEntity(request);
        Category created = service.createCategory(category);

        return CategoryMapper.toResponse(created);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        service.deleteCategory(id);
    }

    @PutMapping("/{id}")
    public CategoryResponse updateCategory(
            @PathVariable Long id,
            @RequestBody CategoryRequest request) {

        Category updated = service.updateCategory(
                id,
                CategoryMapper.toEntity(request)
        );

        return CategoryMapper.toResponse(updated);
    }
}