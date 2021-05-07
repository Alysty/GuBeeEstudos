package controllers;

import exceptions.DbException;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.scene.control.*;
import services.DepartmentServices;
import app.Main;
import controllers.listener.DataChangeListener;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class DepartmentListViewController implements Initializable, DataChangeListener {
    // Declaration of attributes attached to FXML
    @FXML
    private TableView<Department> tableViewDepartment;
    @FXML
    private TableColumn<Department,Integer> tableColumnID;
    @FXML
    private TableColumn<Department,String> tableColumnName;
    @FXML
    private Button buttonRegisterNew;
    @FXML
    private TableColumn<Department, Department> tableColumnEdit;
    @FXML
    private TableColumn<Department, Department> tableColumnRemove;
    //Attributes not attached to FXML
    private DepartmentServices service;
    private ObservableList<Department> observableList;
    //methods with direct attachment to the GUI
    @FXML
    public void buttonRegisterNewAction(ActionEvent actionEvent){
        createDialogFormView(new DepartmentServices(),
                new Department(),
                "/gui/DepartmentFormView.fxml",
                Utils.currentStage(actionEvent));
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
        initEditButtons();
        initRemoveButtons();
    }

    private void createDialogFormView(DepartmentServices departmentServices, Department department, String absolutePath, Stage parentStage){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutePath));
            Pane pane = loader.load();

            DepartmentFormViewController departmentFormViewController = loader.getController();
            departmentFormViewController.setDepartmentEntity(department);
            departmentFormViewController.setDepartmentServices(departmentServices);
            departmentFormViewController.subscribeToDataChangeListener(this);
            departmentFormViewController.updateFormData();
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

    @Override
    public void onDataChanged() {
        updateTableView();
    }

    private void initEditButtons() {
        tableColumnEdit.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        tableColumnEdit.setCellFactory(param -> new TableCell<Department, Department>() {
            private final Button button = new Button("edit");

            @Override
            protected void updateItem(Department department, boolean empty) {
                super.updateItem(department, empty);
                if (department == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(button);
                button.setOnAction(
                        event -> createDialogFormView(
                                 service,department,"/gui/DepartmentFormView.fxml", Utils.currentStage(event)));
            }
        });
    }

    private void initRemoveButtons() {
        tableColumnRemove.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        tableColumnRemove.setCellFactory(param -> new TableCell<Department, Department>() {
            private final Button button = new Button("remove");
            @Override
            protected void updateItem(Department department, boolean empty) {
                super.updateItem(department, empty);
                if (department == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(button);
                button.setOnAction(event -> removeEntity(department));
            }
        });
    }
    private void removeEntity(Department department){
        Optional<ButtonType> resultAlert = Alerts.showConfirmation("Confirm deletion", "Are you sure you want to delete this department? ");
        if(resultAlert.get() == ButtonType.OK){
            if(service==null){
                throw new IllegalStateException("Service variable is null when accessed");
            }
            try {
                service.delete(department);
                updateTableView();
            } catch (DbException e) {
                Alerts.showAlert("Error removing object", null,e.getMessage(), Alert.AlertType.ERROR);
            }
        }
    }

}
