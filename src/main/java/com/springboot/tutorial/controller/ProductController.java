package com.springboot.tutorial.controller;

import com.springboot.tutorial.dto.ProductRequest;
import com.springboot.tutorial.dto.ProductResponse;
import com.springboot.tutorial.mapper.ProductMapper;
import com.springboot.tutorial.model.Product;
import com.springboot.tutorial.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<ProductResponse> getAllProducts(){

        return productService.getAllProducts()
                .stream()
                .map(ProductMapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public ProductResponse getProduct(@PathVariable Long id){

        return ProductMapper.toResponse(productService.getProductById(id));
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(
            @Valid @RequestBody ProductRequest request){

        Product product = ProductMapper.toEntity(request);

        Product created = productService.createProduct(product, request.getCategoryId());

        return ResponseEntity
                .status(201)
                .body(ProductMapper.toResponse(created));
    }

    @PutMapping("/{id}")
    public ProductResponse updateProduct(
            @PathVariable Long id,
            @RequestBody ProductRequest request){

        Product updated = productService.updateProduct(
                id,
                ProductMapper.toEntity(request),
                request.getCategoryId()
        );

        return ProductMapper.toResponse(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){

        productService.deleteProduct(id);

        return ResponseEntity.noContent().build();
    }
}