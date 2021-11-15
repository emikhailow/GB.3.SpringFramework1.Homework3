package com.geekbrains.springwebhomework3.model;

import java.util.Random;

public class Product {
    private Long id;
    private String title;
    private double cost;

    private final Random random = new Random();
    private static final int MIN_PRICE = 1;
    private static final int MAX_PRICE = 1000;

    public Product(Long id, String title, double cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getCost() {
        return cost;
    }

    public Product(Long id) {
        this.id = id;
        this.title = String.format("Item %011d", id);
        generateRandomPrice();
    }

    private void generateRandomPrice() {
        this.cost = MIN_PRICE + (MAX_PRICE - MIN_PRICE) + random.nextDouble();
    }
}
