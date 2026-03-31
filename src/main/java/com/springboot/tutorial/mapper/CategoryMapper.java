package com.springboot.tutorial.mapper;

import com.springboot.tutorial.dto.CategoryRequest;
import com.springboot.tutorial.dto.CategoryResponse;
import com.springboot.tutorial.model.Category;

public class CategoryMapper {

    public static Category toEntity(CategoryRequest request) {
        return new Category(null, request.getName());
    }

    public static CategoryResponse toResponse(Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getName()
        );
    }
}