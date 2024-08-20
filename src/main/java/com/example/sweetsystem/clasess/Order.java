package com.example.sweetsystem.clasess;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    private static int count = 0;
    private final int orderID;
    private int senderID;
    private int productID;
    private int supplierID;
    private int quantity;
    private String orderStatus;
    LocalDateTime time;
    public Order(int senderID, int supplierID, String orderStatus, int quantity, int productID) {
        this.orderID=count;
        count++;
        this.supplierID = supplierID;
        this.senderID = senderID;
        this.orderStatus = orderStatus;
        this.time = LocalDateTime.now();
        this.productID = productID;
        this.quantity = quantity;
    }

    public int getOrderID() {
        return orderID;
    }

    public int getSenderID() {
        return senderID;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(int supplierID) {
        this.supplierID = supplierID;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Sender: " +
                OwnerAndSupplier.getOwnerSupplier(senderID).getUserName() +
                "\nReceiver: " +
                OwnerAndSupplier.getOwnerSupplier(supplierID).getUserName() +
                "\nTimestamp: " +
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(time) +
                "\n";
    }
}
