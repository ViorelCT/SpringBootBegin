package com.springboot.tutorial.dto;

public class ProductResponse {

    private Long id;
    private String name;
    private double price;
    private String priceLabel;
    private String categoryName;

    public ProductResponse(Long id, String name, double price, String priceLabel, String categoryName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.priceLabel = priceLabel;
        this.categoryName = categoryName;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getPriceLabel() {
        return priceLabel;
    }

    public String getCategoryName() {
        return categoryName;
    }
}