package controllers;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController {

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
}
