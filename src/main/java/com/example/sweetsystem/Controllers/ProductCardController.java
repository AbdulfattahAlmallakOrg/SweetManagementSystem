package com.example.sweetsystem.Controllers;

import com.example.sweetsystem.clasess.Product;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductCardController implements Initializable {

    @FXML
    private Text Description;

    @FXML
    private ImageView Image;

    @FXML
    private Text Name;

    @FXML
    private Text Price;

    @FXML
    private Button buyBtn;

    @FXML
    private Label minBtn;

    @FXML
    private Label plusBtn;

    @FXML
    private Text quantity;
    private Product thisProduct;
    private int quantityNum;
    private int currentquantity;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    public void setData(Product product) {
        this.thisProduct=product;
        quantityNum=product.getQuantity();
        makeDataApplayed();
    }

    private void makeDataApplayed() {
        Name.setText(thisProduct.getName());
        Price.setText(thisProduct.getPrice()+" $");
        quantity.setText(0+"");
        currentquantity=0;
        Description.setText(thisProduct.getDescription()+"");
        Image img = new Image(thisProduct.getImage());
        Image.setImage(img);
    }

    public void minusBtn(){
        if(currentquantity<=0){
            currentquantity=0;
            quantity.setText(currentquantity+"");
        }
        else{
            currentquantity-=1;
            quantity.setText(currentquantity+"");
        }
    }
    public void plusBtn(){
        if(currentquantity==quantityNum){
            quantity.setText(currentquantity+"");
            System.out.println(currentquantity);
        }
        else{
            currentquantity+=1;
            quantity.setText(currentquantity+"");
        }
    }

}
