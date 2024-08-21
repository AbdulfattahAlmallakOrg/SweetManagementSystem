package com.example.sweetsystem.Controllers;
import com.example.sweetsystem.clasess.StoreOwner;
import com.example.sweetsystem.clasess.Product;
import com.example.sweetsystem.clasess.Profit;
import com.example.sweetsystem.clasess.User;
import com.example.sweetsystem.clasess.UsersList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class ProfitController {

    @FXML
    private TextField productIdField; // Field to input product ID

    @FXML
    private TextField quantityField; // Field to input quantity sold

    @FXML
    private Button recordButton;

    @FXML
    private Label resultLabel;

    @FXML
    private Label profitLabel; // Label to display profit

    private final List<Product> products = new ArrayList<>(); // List to store products
    private final Profit profit = new Profit(new ArrayList<>()); // Initialize Profit with an empty list

    @FXML
    private void initialize() {
        // Load products from all StoreOwners in UsersList
        for (User user : UsersList.users) {
            if (user.getType().equals("Owner")) {
                StoreOwner owner = (StoreOwner) user;
                //products.addAll(owner.getProducts());
            }
        }

        recordButton.setOnAction(e -> recordSale());
        updateProfitLabel();
    }

    private void recordSale() {
        try {
            int productId = Integer.parseInt(productIdField.getText());
            int quantitySold = Integer.parseInt(quantityField.getText());

            // Find the product by ID
            Product product = products.stream()
                    .filter(p -> p.getId() == productId)
                    .findFirst()
                    .orElse(null);

            if (product != null) {
                profit.recordSale(product, quantitySold);
                resultLabel.setText("Sale recorded successfully.");
            } else {
                resultLabel.setText("Product not found.");
            }
            updateProfitLabel(); // Update profit display
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid quantity or product ID format.");
        }
    }

    private void updateProfitLabel() {
        double totalProfit = profit.getTotalProfit();
        profitLabel.setText("Total Profit: $" + totalProfit);
    }
}
