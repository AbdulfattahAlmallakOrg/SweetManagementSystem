package com.example.sweetsystem;

import com.example.sweetsystem.classes.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OwnerAndSupplier extends User {
    private static final HashMap<Integer, OwnerAndSupplier> map = new HashMap<>();
    private final List<Message> sentMessages;
    private final List<Message> readMessages;
    private final List<Message> unreadMessages;
    private final List<Product> products;
    private static final String INVALID_ID_MESSAGE = "ID is invalid";

    public OwnerAndSupplier(String name, String email, String password, String type) {
        super(name, email, password, type);
        map.put(id, this);
        sentMessages = new ArrayList<>();
        readMessages = new ArrayList<>();
        unreadMessages = new ArrayList<>();
        products = new ArrayList<>();
    }

    public int sendMessage(String content, int receiverId) {
        Message message = new Message(this.id, receiverId, content);
        OwnerAndSupplier receiver = getOwnerSupplier(receiverId);
        if (receiver == null) {
            return 1;
        }
        sentMessages.add(message);
        receiver.receiveMessage(message);
        return 0;
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

    //will be moved to User class
    public static OwnerAndSupplier getOwnerSupplier(int id) {
        return map.getOrDefault(id, null);
    }

    public void increaseProductQuantity(int id, int quantity) {
        Product product = Product.getProduct(id);
        if (product != null && product.getOwnerID() == this.id) {
            product.setQuantity(product.getQuantity() + quantity);
        } else {
            System.out.println(INVALID_ID_MESSAGE);
        }
    }

    public void addNewProduct(String name, String description, double price, int quantity) {
        Product product = new Product(name, description, price, quantity, this.id);
        products.add(product);
    }

    public void updateProduct(int id, String name, String description, double price, int quantity) {
        Product product = Product.getProduct(id);
        if (product != null && product.getOwnerID() == this.id) {
            product.setName(name);
            product.setDescription(description);
            product.setPrice(price);
            product.setQuantity(quantity);
        } else {
            System.out.println(INVALID_ID_MESSAGE);
        }
    }

    public void deleteProduct(int id) {
        Product product = Product.getProduct(id);
        if (product != null && product.getOwnerID() == this.id) {
            products.remove(product);
            Product.removeProduct(id);
        } else {
            System.out.println(INVALID_ID_MESSAGE);
        }
    }


}