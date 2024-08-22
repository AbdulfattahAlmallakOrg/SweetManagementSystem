package com.example.sweetsystem.clasess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OwnerAndSupplier extends User {
    private static final HashMap<Integer, OwnerAndSupplier> map = new HashMap<>();
    private final List<Message> sentMessages;
    private final List<Message> readMessages;
    private final List<Message> unreadMessages;
    private final List<Product> products;
    public static final String INVALID_NAME_MESSAGE = "Name is invalid";
    public static final String INVALID_PRICE_MESSAGE = "Price is invalid";
    public static final String INVALID_QUANTITY_MESSAGE = "Quantity is invalid";
    public static final String INVALID_PERMISSION_MESSAGE = "Permission is invalid";
    public static final String SUCCESSFUL_OPERATION = "successful operation";
    public static final String RECEIVER_DOESNT_EXIST = "receiver does not exist";

    public OwnerAndSupplier(String name, String email, String password, String type, String location) {
        super(name, email, password, type, location);
        map.put(getId(), this);
        sentMessages = new ArrayList<>();
        readMessages = new ArrayList<>();
        unreadMessages = new ArrayList<>();
        products = new ArrayList<>();
    }

    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public List<Message> getReadMessages() {
        return readMessages;
    }

    public List<Message> getUnreadMessages() {
        return unreadMessages;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products.addAll(products);
    }

    public String sendMessage(String content, int receiverId) {
        Message message = new Message(getId(), receiverId, content);
        OwnerAndSupplier receiver = getOwnerSupplier(receiverId);
        if (receiver == null) {
            return RECEIVER_DOESNT_EXIST;
        }
        sentMessages.add(message);
        receiver.receiveMessage(message);
        return SUCCESSFUL_OPERATION;
    }

    public void receiveMessage(Message message) {
        unreadMessages.add(message);
    }

    public void readUnreadMessages() {
        while (!unreadMessages.isEmpty()) {
            Message message = unreadMessages.get(unreadMessages.size() - 1);
            System.out.println(message);
            unreadMessages.remove(unreadMessages.size() - 1);
            readMessages.add(message);
        }
    }

    public static OwnerAndSupplier getOwnerSupplier(int id) {
        return map.getOrDefault(id, null);
    }

    public String increaseProductQuantity(String name, int quantity) {
        if (quantity < 0) return INVALID_QUANTITY_MESSAGE;
        Product product = Product.getProduct(name);
        if (product != null && product.getOwnerID() == getId()) {
            product.setQuantity(product.getQuantity() + quantity);
            return SUCCESSFUL_OPERATION;
        }
        if(product == null) return INVALID_NAME_MESSAGE;
        return INVALID_PERMISSION_MESSAGE;
    }

    public String addNewProduct(String name, String description, double price, int quantity) {
        if (price < 0) {
            return INVALID_PRICE_MESSAGE;
        }
        if(quantity < 0) return INVALID_QUANTITY_MESSAGE;
        Product product = Product.getProduct(name);
        if (product == null || product.getOwnerID() != getId()) {
            product = new Product(name, description, price, quantity, getId());
            products.add(product);
        }
        else {
            product.setQuantity(product.getQuantity() + quantity);
        }
        return SUCCESSFUL_OPERATION;
    }

    public String updateProduct(String name, String description, double price, int quantity) {
        Product product = Product.getProduct(name);
        if (price < 0) return INVALID_PRICE_MESSAGE;
        if (quantity < 0) return INVALID_QUANTITY_MESSAGE;
        if (product != null && product.getOwnerID() == this.getId()) {
            product.setDescription(description);
            product.setPrice(price);
            product.setQuantity(quantity);
            return SUCCESSFUL_OPERATION;
        }
        if(product == null) return INVALID_NAME_MESSAGE;
        else return INVALID_PERMISSION_MESSAGE;
    }

    public String deleteProduct(String name) {
        Product product = Product.getProduct(name);
        if (product != null && product.getOwnerID() == getId()) {
            products.remove(product);
            Product.removeProduct(product.getName());
        }
        if(product == null) return INVALID_NAME_MESSAGE;
        return INVALID_PERMISSION_MESSAGE;
    }
}