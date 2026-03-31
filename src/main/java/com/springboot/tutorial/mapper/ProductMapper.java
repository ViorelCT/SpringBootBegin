package com.springboot.tutorial.mapper;

import com.springboot.tutorial.dto.ProductRequest;
import com.springboot.tutorial.dto.ProductResponse;
import com.springboot.tutorial.model.Product;

public class ProductMapper {

    public static Product toEntity(ProductRequest dto) {
        return new Product(null, dto.getName(), dto.getPrice());
    }

    public static ProductResponse toResponse(Product product) {

        String priceLabel = product.getPrice() + " USD";

        String categoryName = product.getCategory() != null
                ? product.getCategory().getName()
                : null;

        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getPrice(),
                priceLabel,
                categoryName
        );
    }
}