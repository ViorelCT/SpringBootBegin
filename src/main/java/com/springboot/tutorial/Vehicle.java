package com.springboot.tutorial;

public class Vehicle {

    private String brand;
    private String model;
    private int year;

    public Vehicle (String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public Vehicle (String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.year = 2016;
    }

    public void setBrand (String brand) {
        if (brand != null && !brand.trim().isEmpty()) {
            this.brand = brand;
        }
        else {
            System.out.println("Invalid brand");
        }
    }

    public void setModel (String model) {
        this.model = model;
    }

    public void setYear (int year) {
        if (year > 1900) {
            this.year = year;
        }
        else {
            System.out.println("Invalid year");
        }
    }

    public String getBrand () {
        return brand;
    }

    public String getModel () {
        return model;
    }

    public int getYear () {
        return year;
    }

    public String getCarDetails() {
        return brand + " " + model + " " + year;
    }

    void Start(){
        System.out.println(brand + " " + model + " " + year + " started");
    }
}
