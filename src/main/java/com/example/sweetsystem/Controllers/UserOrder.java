package com.example.sweetsystem.Controllers;

public class UserOrder {
    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUserName() {
        return userName;
    }

    private int productId;
    private int quantity;
    private String userName;

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    UserOrder(int productId,String userName,int quantity){
    this.productId=productId;
    this.userName=userName;
    this.quantity=quantity;
    }

}
