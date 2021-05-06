package controllers;

import Services.DepartmentServices;
import app.Main;
import entities.Department;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class DepartmentListViewController implements Initializable {
    // Declaration of attributes attached to FXML
    @FXML
    private TableView<Department> tableViewDepartment;
    @FXML
    private TableColumn<Department,Integer> tableColumnID;
    @FXML
    private TableColumn<Department,String> tableColumnName;
    @FXML
    private Button buttonRegisterNew;

    //Attributes not attached to FXML
    private DepartmentServices service;
    private ObservableList<Department> observableList;
    //methods attached to the GUI
    @FXML
    public void buttonRegisterNewAction(){
        System.out.println("Test for the method: ButtonRegisterNewAction");
    }

    //methods not attached to FXML
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeNodes();
        setDepartmentService(new DepartmentServices());
        updateTableView();
    }

    private void initializeNodes(){
        tableColumnID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        Stage stage = (Stage) Main.getMainScene().getWindow();
        tableViewDepartment.prefHeightProperty().bind(stage.heightProperty());

    }

    public void setDepartmentService(DepartmentServices service) {
        this.service = service;
    }
    public void updateTableView(){
        if(service==null){
            throw new IllegalStateException("service variable was null");
        }
        List<Department> list = service.findAll();
        observableList = FXCollections.observableArrayList(list);
        tableViewDepartment.setItems(observableList);
    }
}
