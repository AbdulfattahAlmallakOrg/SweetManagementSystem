package com.example.sweetsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class Main {
@FXML
private AnchorPane ParentPane;


    public void goToManageAccount() throws IOException {
        AnchorPane root= FXMLLoader.load(Objects.requireNonNull(getClass().getResource("ManageAccount.fxml")));
        ParentPane.getChildren().setAll(root);
    }

}
