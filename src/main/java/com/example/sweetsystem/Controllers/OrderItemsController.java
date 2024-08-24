package com.example.sweetsystem.Controllers;

import com.example.sweetsystem.clasess.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class OrderItemsController {
    @FXML
    private ImageView img;

    @FXML
    private Text nameLabel;

    @FXML
    private Text numQ;
    @FXML
    private Text numQ1;

    @FXML
    private Circle statusC;

    @FXML
    private Label statusT;
    @FXML
    private Label edt;
    UserOrder userOrder2;
    public void setData(UserOrder userOrder) {
    statusT.setText(userOrder.getStatus());
        numQ.setText("Qantity : "+userOrder.getQuantity()+"");
        nameLabel.setText(userOrder.getP().getName());
        userOrder2=userOrder;
        numQ1.setText("Total :"+userOrder.getTotal()+"");
        try {
            fillImage(userOrder.getP());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        if(userOrder.getStatus().equals("Pinding")){
            statusC.setStyle("-fx-background-color: ORANGE");
            edt.setVisible(true);
        }
        else{
            edt.setVisible(false);
        }
    }
    private void fillImage(Product thisProduct) throws FileNotFoundException {
        FileInputStream input = new FileInputStream(thisProduct.getImage());
        Image imgg = new Image(input);
        img.setImage(imgg);
    }

    public void changeState(){
        statusC.setFill(Color.GREEN);
        edt.setVisible(false);
        userOrder2.setStatus("Dilevird");
        statusT.setText("Dilevird");
    }


}
