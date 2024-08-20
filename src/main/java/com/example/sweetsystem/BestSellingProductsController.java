package com.example.sweetsystem;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class BestSellingProductsController {

    @FXML
    private ComboBox<String> storeComboBox;

    @FXML
    private TableView<Product> productsTable;

    @FXML
    private TableColumn<Product, String> productNameColumn;

    @FXML
    private TableColumn<Product, Integer> quantitySoldColumn;

    private List<Store> stores; // List to hold store data

    @FXML
    public void initialize() {
        // Initialize table columns
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        quantitySoldColumn.setCellValueFactory(new PropertyValueFactory<>("quantitySold"));

        // Populate the ComboBox with store names
        storeComboBox.getItems().addAll(getStoreNames());
    }

    @FXML
    public void showBestSellingProducts() {
        String selectedStore = storeComboBox.getValue();
        if (selectedStore != null) {
            // Retrieve best-selling products for the selected store
            productsTable.getItems().clear(); // Clear previous results
            productsTable.getItems().addAll(getBestSellingProducts(selectedStore));
        }
    }

    private List<Product> getBestSellingProducts(String storeName) {

        // Find the store by its name
        Store store = findStoreByName(storeName);
        if (store != null) {
            return store.getBestSellingProducts();
        }
        return List.of(); // Return an empty list if store is not found
    }

    private Store findStoreByName(String storeName) {
        // Search for the store in the list of stores
        for (Store store : stores) {
            if (store.getName().equals(storeName)) {
                return store;
            }
        }
        return null; // Return null if store is not found
    }

    private List<String> getStoreNames() {
        // Retrieve store names from the list of stores
        return stores.stream()
                .map(Store::getName)
                .toList();
    }

    // Setter for the stores list
    public void setStores(List<Store> stores) {
        this.stores = stores;
        storeComboBox.getItems().setAll(getStoreNames()); // Update ComboBox with store names
    }

    public static class Product {
        private final String productName;
        private final int quantitySold;

        public Product(String productName, int quantitySold) {
            this.productName = productName;
            this.quantitySold = quantitySold;
        }

        public String getProductName() {
            return productName;
        }

        public int getQuantitySold() {
            return quantitySold;
        }
    }

    public static class Store {
        private final String name;
        private final List<Product> products;

        public Store(String name, List<Product> products) {
            this.name = name;
            this.products = products;
        }

        public String getName() {
            return name;
        }

        public List<Product> getBestSellingProducts() {
            // Sort and return the best-selling products
            return products.stream()
                    .sorted((p1, p2) -> Integer.compare(p2.getQuantitySold(), p1.getQuantitySold()))
                    .toList();
        }
    }
}
