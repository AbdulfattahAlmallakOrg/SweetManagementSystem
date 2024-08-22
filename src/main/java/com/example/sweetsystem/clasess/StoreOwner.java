package com.example.sweetsystem.clasess;
import java.util.List;

public class StoreOwner extends OwnerAndSupplier {
    private final List<String> products;
    private static final String NOT_AN_INSTANCE_MESSAGE = "Not an instance";
    public StoreOwner(String name, String email, String type, String password, List<String> products, String location) {
        super(name, email, password, type, location);
        this.products = products;
    }

    public  void requestOrder(int productId, int supplierId, int quantity) {
        OwnerAndSupplier supplier = getOwnerSupplier(supplierId);
        if (!(supplier instanceof Supplier supplier2)) {
            System.out.println(NOT_AN_INSTANCE_MESSAGE);
        }
        else {
            Order order = new Order(getId(), supplierId, "pending", quantity, productId);
            supplier2.receiveOrder(order);
        }
    }
}