package com.example.sweetsystem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import com.example.sweetsystem.StoreOwner;
import com.example.sweetsystem.clasess.User;
import com.example.sweetsystem.clasess.UsersList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;





public class Admin  {
@FXML
private Button RawSup;
@FXML
private Button Owner;
@FXML
private Button GoTosail;
@FXML
private Button GoToBest;
@FXML
private Button GOByCities;
    @FXML
    public AnchorPane MainPane;

    /* public Admin(ArrayList<StoreOwner> storeOwners, ArrayList<Supplier> suppliers) {
           this.storeOwners = storeOwners;
           this.suppliers = suppliers;
       }*/
    @FXML
    public void goToOwnerPage() throws IOException {
        AnchorPane root= FXMLLoader.load(getClass().getResource("AdminOwnerPage.fxml"));
        MainPane.getChildren().setAll(root);
        Index.header.setText("Admin Page");
    }
   public void goToRawPage() throws IOException {
        AnchorPane root=FXMLLoader.load(Objects.requireNonNull(getClass().getResource("RawSupplier.fxml")));
       MainPane.getChildren().setAll(root);
       Index.header.setText("Raw Page");

   }
    @FXML
    public void GoToSaillng() throws IOException {
        StackPane root= FXMLLoader.load(getClass().getResource("ProfitController.fxml"));
        MainPane.getChildren().setAll(root);
        Index.header.setText("Sail");
    }
    @FXML
    public void GOBestSell() throws IOException {
        StackPane root= FXMLLoader.load(getClass().getResource("BestSellingProductsController.fxml"));
        MainPane.getChildren().setAll(root);
        Index.header.setText("Best sail");
    }
    @FXML
    public void GOToCities() throws IOException {
        StackPane root= FXMLLoader.load(getClass().getResource("UserStatisticsController.fxml"));
        MainPane.getChildren().setAll(root);
        Index.header.setText("Cities");
    }


   /* public void removeStoreOwner(StoreOwner owner) {
        storeOwners.remove(owner);
        System.out.println("Store Owner removed: " + owner);
    }

    public void updateStoreOwnerByName(String oldOwnerName, String newOwnerName, String newEmail, String newPassword) {
        StoreOwneer owner = searchStoreOwnerByName(oldOwnerName);
        if (owner != null) {
            owner.setOwnerName(newOwnerName);
            owner.setEmail(newEmail);
            owner.setPassword(newPassword);
            System.out.println("Store Owner updated: " + owner);
        } else {
            System.out.println("Store Owner with name " + oldOwnerName + " not found.");
        }
    }

    // Methods for RawMaterialSuppliers
    public void addSupplier(RawMaterialSupplier supplier) {
        suppliers.add(supplier);
        System.out.println("Supplier added: " + supplier);
    }

    public void removeSupplier(RawMaterialSupplier supplier) {
        suppliers.remove(supplier);
        System.out.println("Supplier removed: " + supplier);
    }

    public void updateSupplierByName(String oldSupplierName, String newSupplierName, String newEmail, String newPassword) {
        RawMaterialSupplier supplier = searchSupplierByName(oldSupplierName);
        if (supplier != null) {
            supplier.setSupplierName(newSupplierName);
            supplier.setEmail(newEmail);
            supplier.setPassword(newPassword);
            System.out.println("Supplier updated: " + supplier);
        } else {
            System.out.println("Supplier with name " + oldSupplierName + " not found.");
        }
    }

    // Search methods
    public StoreOwner searchStoreOwnerByName(String ownerName) {
        int index=UsersList.search(ownerName);
       if(index==-1){
           System.out.println("dose not exist");
       }
       else{
        StoreOwner s;
               s=(StoreOwner) UsersList.users.get(index);
         return s;
       }
        return null;
    }

    public RawMaterialSupplier searchSupplierByName(String supplierName) {
        for (RawMaterialSupplier supplier : suppliers) {
            if (supplier.getSupplierName().equals(supplierName)) {
                return supplier;
            }
        }
        System.out.println("Supplier with name " + supplierName + " not found.");
        return null;
    }*/
}
