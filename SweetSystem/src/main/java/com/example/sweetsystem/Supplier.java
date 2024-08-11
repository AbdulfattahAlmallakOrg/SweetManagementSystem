package com.example.sweetsystem;

import java.util.List;

public class Supplier extends OwnerAndSupplier{
    private List<Order> orders;
    Supplier(String name, String email, String password, String type,String location) {
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
