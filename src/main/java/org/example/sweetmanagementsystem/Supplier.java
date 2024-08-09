package org.example.sweetmanagementsystem;

import java.util.List;

public class Supplier extends OwnerAndSupplier{
    private List<Order> orders;
    Supplier(String name, String email, String password, String type) {
        super(name, email, password, type);
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
