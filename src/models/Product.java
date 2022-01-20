package models;

import java.util.Date;

public abstract class Product<T> {
    private String name;
    private String brand;
    private double price;
    private double discount;

    public Product(String name, String brand, double price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double calculateDiscount(Date dateOfPurchase);

    public abstract void print(T quantity, Date dateOfPurchase);

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
