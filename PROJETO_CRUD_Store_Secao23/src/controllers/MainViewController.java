package controllers;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {
    // Declaration of attributes
    @FXML
    private MenuItem menuItemSeller;
    @FXML
    private MenuItem menuItemDepartment;
    @FXML
    private MenuItem menuItemAbout;

    //methods
    @FXML
    private void menuItemSellerAction(){
        System.out.println("testing : menuItemSellerAction");
    }
    @FXML
    private void menuItemDepartmentAction(){
        System.out.println("testing : menuItemDepartmentAction");
    }
    @FXML
    private void menuItemAboutAction(){
        System.out.println("testing : menuItemAboutAction");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
