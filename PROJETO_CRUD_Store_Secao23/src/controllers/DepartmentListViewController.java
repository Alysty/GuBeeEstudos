package controllers;

import Services.DepartmentServices;
import app.Main;
import entities.Department;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
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
    //methods with direct attachment to the GUI
    @FXML
    public void buttonRegisterNewAction(ActionEvent actionEvent){
        createDialogFormView("/gui/DepartmentFormView.fxml", Utils.currentStage(actionEvent));
    }

    //methods not attached to FXML directly
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

    private void createDialogFormView(String absolutePath, Stage parentStage){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutePath));
            Pane pane = loader.load();
            Stage newStage = new Stage();
            newStage.setTitle("Register a new Department");
            newStage.setScene(new Scene(pane));
            newStage.initOwner(parentStage);
            newStage.setResizable(Boolean.FALSE);
            newStage.initModality(Modality.WINDOW_MODAL);
            newStage.showAndWait();
        }catch (IOException e){
            Alerts.showAlert("Error loading new view",null, "ERROR loading view DepartmentFormView with error message:" + e, Alert.AlertType.ERROR);
        }
    }
}
