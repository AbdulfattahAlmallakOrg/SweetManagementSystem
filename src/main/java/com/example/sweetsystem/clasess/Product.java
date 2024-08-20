package com.example.sweetsystem.clasess;

import java.util.HashMap;

public class Product {
    private static int idCounter = 0;
    private final int id;
    private final int ownerID;
    private String name;
    private String description;

    private double price;
    private int quantity;
    private static final HashMap<String, Product> map = new HashMap<>();


    private String image;//the url of the product.




    public Product(String name, String description, double price, int quantity, int ownerID) {
        this.id = idCounter;
        idCounter++;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.ownerID = ownerID;
        map.put(this.name, this);
    }

    public int getId() {
        return id;
    }

    public int getOwnerID() {
        return ownerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static Product getProduct(String name) {
        return map.getOrDefault(name, null);
    }

    public static void removeProduct(String name) {
        map.remove(name);
    }
}
