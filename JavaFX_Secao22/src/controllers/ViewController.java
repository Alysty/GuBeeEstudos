package controllers;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class ViewController {

    @FXML
    private Button bt;

    @FXML
    public void onBtAction(){
        Alerts.showAlert("Title", null,"This was a mistake", Alert.AlertType.WARNING);
    }
}
