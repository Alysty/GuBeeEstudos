package controllers;

import app.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.IOException;
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

    //methods attached to the GUI
    @FXML
    private void menuItemSellerAction(){
        System.out.println("testing : menuItemSellerAction");
    }
    @FXML
    private void menuItemDepartmentAction(){
        loadView("/gui/DepartmentListView.fxml ");
    }
    @FXML
    private void menuItemAboutAction(){
        loadView("/gui/AboutView.fxml");
    }

    // Other methods
    private void loadView(String absolutePathFile){
        try {
            // Get new view
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutePathFile));
            System.out.println(loader.getLocation());
            VBox newVBox = loader.load();
            // Get main view
            Scene mainScene = Main.getMainScene();
            //Alter main view to have the contents of the new view
            VBox mainVBox = (VBox) ((ScrollPane)mainScene.getRoot()).getContent();
            // save menu for it to appear in every view
            Node mainMenu = mainVBox.getChildren().get(0);
            mainVBox.getChildren().clear();
            mainVBox.getChildren().add(mainMenu);
            mainVBox.getChildren().addAll(newVBox.getChildren());

        } catch (IOException e) {
            Alerts.showAlert("Alert trying to load screen",
                    null,
                    "An error occurred when trying to load the file " + absolutePathFile,
                    Alert.AlertType.ERROR);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
