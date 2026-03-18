package com.springboot.tutorial.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Product {

    private Long id;

    @NotBlank(message = "Name cannot be empty")
    @Min(value = 3, message = "The product name has to be at least 3 characters")
    private String name;

    @Min(value = 1, message = "Price must be greater than 0")
    private double price;

    public Product() {}

    public Product(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {

        if(price < 0){
            throw new IllegalArgumentException("Price cannot be negative");
        }

        this.price = price;
    }
}