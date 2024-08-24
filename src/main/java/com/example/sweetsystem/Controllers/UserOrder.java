package com.example.sweetsystem.Controllers;

import com.example.sweetsystem.clasess.Product;

public class UserOrder {
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private  String status;

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUserName() {
        return userName;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    private int storeId;
    private int productId;
    private int quantity;
    private String userName;

    public Product getP() {
        return p;
    }

    private Product p;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    private double total;


    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    UserOrder(int productId,String userName,int quantity,int storeId,String status,double unitPrice){
    this.productId=productId;
    this.userName=userName;
    this.quantity=quantity;
    this.storeId=storeId;
    this.status=status;
    searchP(productId);
    totalCalc(unitPrice);
    }

    private void totalCalc(double unitPrice) {
        double x=this.quantity*unitPrice;
        total=x;
    }

    private void searchP(int productId) {
        for(int i=0;i<Product.products.size();i++){
            if(Product.products.get(i).getId()==productId){
                this.p=Product.products.get(i);
            }
        }
    }

}
