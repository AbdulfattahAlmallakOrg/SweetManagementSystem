package com.example.sweetsystem.clasess;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    public static int count = 0;
    private int orderID;
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

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Sender: ");
        sb.append(OwnerAndSupplier.getOwnerSupplier(senderID).getUserName());
        sb.append("\nReceiver: ");
        sb.append(OwnerAndSupplier.getOwnerSupplier(supplierID).getUserName());
        sb.append("\nTimestamp: ");
        sb.append(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(time));
        sb.append("\n");
        return sb.toString();
    }
}
