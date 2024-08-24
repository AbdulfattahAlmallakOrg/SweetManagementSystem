package com.example.sweetsystem.Controllers;

import com.example.sweetsystem.clasess.Order;
import com.example.sweetsystem.clasess.Product;
import com.example.sweetsystem.clasess.UsersList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
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
    private HBox alert;
    private HBox alert2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    public void setData(Product product, HBox com,HBox com2) {
        alert=com;
        alert2=com2;
        this.thisProduct=product;
        quantityNum=product.getQuantity();
        makeDataApplayed();
    }

    private void makeDataApplayed() {
        Name.setText(thisProduct.getName());
        Price.setText(thisProduct.getPrice()+" $");
        quantity.setText(1+"");
        currentquantity=1;
        Description.setText(thisProduct.getDescription()+"");
        try {
            fillImage(thisProduct);

        }catch (Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    private void fillImage(Product thisProduct) throws FileNotFoundException {
        FileInputStream input = new FileInputStream(thisProduct.getImage());
        Image img = new Image(input);
        Image.setImage(img);
    }

    public void minusBtn(){
        if(currentquantity<=0){
            currentquantity=0;
            quantity.setText(currentquantity+"");
        }
        else{

            currentquantity-=1;
            Price.setText(currentquantity*thisProduct.getPrice()+" $");

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
            Price.setText(currentquantity*thisProduct.getPrice()+" $");

            quantity.setText(currentquantity+"");
        }
    }
    public void buyBtn(){

        if(thisProduct.getQuantity()>=currentquantity) {
            System.out.println(thisProduct.getQuantity());
            UserOrder o=new UserOrder(thisProduct.getId(),UsersList.currentUser.getUserName(),currentquantity,thisProduct.getOwnerID(),"Pinding",thisProduct.getPrice());
            UserOrderHelper.orders.add(o);
            thisProduct.setQuantity(quantityNum - currentquantity);
            quantityNum=thisProduct.getQuantity();
            System.out.println("here: "+quantityNum);
            alert.setVisible(true);
            currentquantity=1;
            quantity.setText(currentquantity+"");
            Price.setText(thisProduct.getPrice()+" $");
        }
        else {
            alert2.setVisible(true);
        }
        System.out.println(thisProduct.getQuantity());

    }


}
