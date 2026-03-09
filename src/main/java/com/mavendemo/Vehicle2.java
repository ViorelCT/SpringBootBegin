package com.mavendemo;

public class Vehicle2 {

    private String brand;
    private int capacity;

    public Vehicle2 (String brand) {
        this.brand = brand;
        this.capacity = 5;
    }

    public Vehicle2 (String brand, int capacity) {
        this.brand = brand;
        this.capacity = capacity;
    }

    public void setBrand (String brand) {
        this.brand = brand;
    }

    public void setYear (int capacity) {
        this.capacity = capacity;
    }

    public String getBrand () {
        return brand;
    }

    public int getCapacity () {
        return capacity;
    }

}
