package com.springboot.tutorial.dto;

public class ProductResponse {

    private Long id;
    private String name;
    private double price;
    private String priceLabel;

    public ProductResponse(Long id, String name, double price, String priceLabel) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.priceLabel = priceLabel;
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
}