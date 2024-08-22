package com.example.sweetsystem.clasess;

import java.util.ArrayList;
import java.util.List;

public class Supplier extends OwnerAndSupplier {
    private final List<Order> orders = new ArrayList<>();
    public Supplier(String name, String email, String password, String type,String location) {
        super(name, email, password, type,location);
    }

    public void receiveOrder(Order order) {
        order.setOrderStatus("received");
        orders.add(order);
    }

    public void endOrder(Order order) {
        order.setOrderStatus("done");
        orders.remove(order);
    }
}
