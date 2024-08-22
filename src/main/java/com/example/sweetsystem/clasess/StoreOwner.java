package com.example.sweetsystem.clasess;
import java.util.List;

public class StoreOwner extends OwnerAndSupplier {
    private final List<String> products;
    public static final String NOT_AN_INSTANCE_MESSAGE = "Not an instance";
    public StoreOwner(String name, String email, String type, String password, List<String> products, String location) {
        super(name, email, password, type, location);
        this.products = products;
    }

    public String requestOrder(int productId, int supplierId, int quantity) {
        OwnerAndSupplier supplier = getOwnerSupplier(supplierId);
        if (!(supplier instanceof Supplier supplier2)) return NOT_AN_INSTANCE_MESSAGE;
        if (quantity <= 0) return INVALID_QUANTITY_MESSAGE;
        Order order = new Order(getId(), supplierId, "pending", quantity, productId);
        supplier2.receiveOrder(order);
        return SUCCESSFUL_OPERATION;
    }
}