package com.example.sweetsystem;

import com.example.sweetsystem.clasess.RawSupplier;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.HashMap;
import java.util.Map;

public class RawSupplierController {

    // FXML variables
    @FXML
    private TextField NameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField IDField;
    @FXML
    private TextField locationo;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField typeField;
    @FXML
    private Button addButton;
    @FXML
    private TextField deleteIDField;
    @FXML
    private Button deleteButton;
    @FXML
    private TextField searchIDField;
    @FXML
    private Button searchButton;
    @FXML
    private TextField updateIDField;
    @FXML
    private TextField updateNameField;
    @FXML
    private TextField updateEmailField;
    @FXML
    private TextField updateTypeField;
    @FXML
    private TextField updatePasswordField;
    @FXML
    private Button updateButton;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox vboxContent;
    @FXML
    private VBox vboxResults;
    @FXML
    private TextField updateLocationField;

    private final Map<String, RawSupplier> suppliers = new HashMap<>();

    @FXML

    private void initialize() {

      /*  NameField.setPromptText("Enter name");
        emailField.setPromptText("Enter email");
        IDField.setPromptText("Enter ID");
        locationo.setPromptText("Enter type");
        passwordField.setPromptText("Enter location");
        typeField.setPromptText("Enter pass");

        vboxContent.getChildren().clear();
        vboxResults.getChildren().clear();

        addButton.setOnAction(event -> addRawSupplier());
        deleteButton.setOnAction(event -> deleteRawSupplier());
        searchButton.setOnAction(event -> searchRawSupplier());
        updateButton.setOnAction(event -> updateRawSupplier());*/
    }


    // Add Raw Supplier method
    @FXML
    private void addRawSupplier() {
        String name = NameField.getText();
        String email = emailField.getText();
        String id = IDField.getText();
        String location = locationo.getText();
        String password = passwordField.getText();
        String type = typeField.getText();

        RawSupplier supplier = new RawSupplier(name, email, id, type, location, password);
        suppliers.put(id, supplier);

        displaySupplier(supplier);

        // Clear fields after adding
        NameField.clear();
        emailField.clear();
        IDField.clear();
        locationo.clear();
        passwordField.clear();
        typeField.clear();
    }

    // Delete Raw Supplier method
    @FXML
    private void deleteRawSupplier() {
        String id = deleteIDField.getText();
        suppliers.remove(id);

        // Clear the VBox content
        vboxContent.getChildren().clear();

        // Reload all suppliers
        for (RawSupplier supplier : suppliers.values()) {
            displaySupplier(supplier);
        }

        // Clear field after deletion
        deleteIDField.clear();
    }

    // Search Raw Supplier method
    @FXML
    private void searchRawSupplier() {
        String id = searchIDField.getText();
        RawSupplier supplier = suppliers.get(id);

        // Clear previous search results
        vboxResults.getChildren().clear();

        if (supplier != null) {
            Label resultLabel = new Label(
                    "Email: " + supplier.getEmail() + "\n" +
                            "ID: " + supplier.getID() + "\n" +
                            "Email: " + supplier.getEmail() + "\n" +
                            "Type: " + supplier.getType() + "\n" +
                            "Location: " + supplier.getLocation() + "\n" +
                            "Password: " + supplier.getPassword()
            );
            vboxResults.getChildren().add(resultLabel);
        } else {
            vboxResults.getChildren().add(new Label("Supplier not found"));
        }

        // Clear field after search
        searchIDField.clear();
    }

    // Update Raw Supplier method
    @FXML
    private void updateRawSupplier() {
        String id = updateIDField.getText();
        RawSupplier supplier = suppliers.get(id);

        if (supplier != null) {
            supplier.setUserName(updateNameField.getText());
            supplier.setEmail(updateEmailField.getText());
            supplier.setLocation(updateLocationField.getText());
            supplier.setPassword(updatePasswordField.getText());
            supplier.setType(updateTypeField.getText());

            // Clear previous content and reload suppliers
            vboxContent.getChildren().clear();
            for (RawSupplier s : suppliers.values()) {
                displaySupplier(s);
            }

            // Clear fields after updating
            updateIDField.clear();
            updateNameField.clear();
            updateEmailField.clear();
            updateTypeField.clear();
            updatePasswordField.clear();
            updateLocationField.clear();
        } else {
            vboxResults.getChildren().clear();
            vboxResults.getChildren().add(new Label("Supplier with ID " + id + " not found"));
        }
    }

    // Method to display supplier in VBox
    private void displaySupplier(RawSupplier supplier) {
        HBox supplierBox = new HBox();
        supplierBox.getChildren().addAll(
                new Label("Name: " + supplier.getUserName() + " "),
                new Label("ID: " + supplier.getId() + " "),
                new Label("Email: " + supplier.getEmail() + " "),
                new Label("Type: " + supplier.getType() + " "),
                new Label("Location: " + supplier.getLocation() + " "),
                new Label("Password: " + supplier.getPassword())
        );
        vboxContent.getChildren().add(supplierBox);
    }
}
