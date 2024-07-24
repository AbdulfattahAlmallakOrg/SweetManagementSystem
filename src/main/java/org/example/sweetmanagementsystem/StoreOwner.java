package org.example.sweetmanagementsystem;

import java.util.List;

public class StoreOwner extends OwnerAndSupplier {
    private List<String> products;
    public StoreOwner(String name, String email, String accountDetails, List<String> products) {
        super(name, email, accountDetails);
        this.products = products;
    }
}
