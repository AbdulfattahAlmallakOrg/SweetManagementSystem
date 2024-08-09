package com.example.sweetsystem;

import java.util.List;

public class StoreOwner extends OwnerAndSupplier {
    private List<String> products;
    public StoreOwner(String name, String email, String type, String password, List<String> products) {
        super(name, email, password, type);
        this.products = products;
    }

    public int requestOrder(int productId, int supplierId, int quantity) {
        OwnerAndSupplier supplier = getOwnerSupplier(supplierId);
        if (!(supplier instanceof Supplier)) {
            return 1;
        }
        Order order = new Order(this.id, supplierId, "pending", quantity, productId);
        ((Supplier) supplier).receiveOrder(order);
        return 0;
    }
}
