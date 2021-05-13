package controllers;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewController implements Initializable {

    @FXML
    private Button btCalculate;
    @FXML
    private Label lbResult;
    @FXML
    private TextField txtFirstNumber;
    @FXML
    private TextField txtSecondNumber;
    @FXML
    public void onBtCalculateAction(){
        try{
            Double result = Double.parseDouble(txtFirstNumber.getText()) + Double.parseDouble(txtSecondNumber.getText()) ;
            lbResult.setText(String.format("%.2f", result));
        }catch(NumberFormatException e){
            Alerts.showAlert("Error on calculation", null,"Please only use numbers", Alert.AlertType.WARNING);
            System.out.println("ERROR"+ e +"ERROR");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Contrains.setTextFieldToDouble(txtFirstNumber);
        Contrains.setTextFieldToAMaxLength(txtFirstNumber,10);
        Contrains.setTextFieldToDouble(txtSecondNumber);
        Contrains.setTextFieldToAMaxLength(txtSecondNumber,10);
    }
}
