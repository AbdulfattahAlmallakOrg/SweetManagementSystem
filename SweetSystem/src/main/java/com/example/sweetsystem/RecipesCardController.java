package com.example.sweetsystem;

import com.example.sweetsystem.clasess.Recipe;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;

public class RecipesCardController {

    @FXML
    private ImageView cakeImage;

    @FXML
    private Label cakeName;
    public void setData(Recipe r) throws FileNotFoundException {
        FileInputStream input = new FileInputStream(r.getImage());
        Image img = new Image(input);
        cakeImage.setImage(img);
    cakeName.setText(r.getName());

    }
}
