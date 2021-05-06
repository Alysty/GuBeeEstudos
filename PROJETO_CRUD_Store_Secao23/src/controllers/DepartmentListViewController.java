package controllers;

import app.Main;
import entities.Department;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DepartmentListViewController implements Initializable {
    // Declaration of attributes
    @FXML
    private TableView<Department> tableViewDepartment;
    @FXML
    private TableColumn<Department,Integer> tableColumnID;
    @FXML
    private TableColumn<Department,String> tableColumnName;
    @FXML
    private Button buttonRegisterNew;

    //methods attached to the GUI
    @FXML
    public void buttonRegisterNewAction(){
        System.out.println("Test for the method: ButtonRegisterNewAction");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeNodes();
    }
    private void initializeNodes(){
        tableColumnID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        Stage stage = (Stage) Main.getMainScene().getWindow();
        tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());
    }
}
