package controllers;

import exceptions.DbException;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.scene.control.*;
import services.SellerServices;
import app.Main;
import controllers.listener.DataChangeListener;
import entities.Seller;
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
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class SellerListViewController implements Initializable, DataChangeListener {
    // Declaration of attributes attached to FXML
    @FXML
    private TableView<Seller> tableViewSeller;
    @FXML
    private Button buttonRegisterNew;
    @FXML
    private TableColumn<Seller, Integer> tableColumnID;
    @FXML
    private TableColumn<Seller, String> tableColumnName;
    @FXML
    private TableColumn<Seller, String> tableColumnEmail;
    @FXML
    private TableColumn<Seller, Date> tableColumnBirthDate;
    @FXML
    private TableColumn<Seller, Double> tableColumnSalary;
    @FXML
    private TableColumn<Seller, Seller> tableColumnEdit;
    @FXML
    private TableColumn<Seller, Seller> tableColumnRemove;
    //Attributes not attached to FXML
    private SellerServices service;
    private ObservableList<Seller> observableList;
    //methods with direct attachment to the GUI
    @FXML

    public void buttonRegisterNewAction(ActionEvent actionEvent){
        /*createDialogFormView(new SellerServices(),
                new Seller(),
                "/gui/SellerFormView.fxml",
                Utils.currentStage(actionEvent));*/
    }

    //methods not attached to FXML directly
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeNodes();
        setSellerService(new SellerServices());
        updateTableView();
    }

    private void initializeNodes(){
        tableColumnID.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableColumnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableColumnBirthDate.setCellValueFactory(new PropertyValueFactory<>("birthDate"));
        Utils.formatTableColumnDate(tableColumnBirthDate,"dd/MM/yy");
        tableColumnSalary.setCellValueFactory(new PropertyValueFactory<>("baseSalary"));
        Utils.formatTableColumnDouble(tableColumnSalary, 2);
        Stage stage = (Stage) Main.getMainScene().getWindow();
        tableViewSeller.prefHeightProperty().bind(stage.heightProperty());

    }

    public void setSellerService(SellerServices service) {
        this.service = service;
    }
    public void updateTableView(){
        if(service==null){
            throw new IllegalStateException("service variable was null");
        }
        List<Seller> list = service.findAll();
        observableList = FXCollections.observableArrayList(list);
        tableViewSeller.setItems(observableList);
        initEditButtons();
        initRemoveButtons();
    }
/*
    private void createDialogFormView(SellerServices sellerServices, Seller seller, String absolutePath, Stage parentStage){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(absolutePath));
            Pane pane = loader.load();

            SellerFormViewController sellerFormViewController = loader.getController();
            sellerFormViewController.setSellerEntity(seller);
            sellerFormViewController.setSellerServices(sellerServices);
            sellerFormViewController.subscribeToDataChangeListener(this);
            sellerFormViewController.updateFormData();
            Stage newStage = new Stage();
            newStage.setTitle("Register a new Seller");
            newStage.setScene(new Scene(pane));
            newStage.initOwner(parentStage);
            newStage.setResizable(Boolean.FALSE);
            newStage.initModality(Modality.WINDOW_MODAL);
            newStage.showAndWait();
        }catch (IOException e){
            Alerts.showAlert("Error loading new view",null, "ERROR loading view SellerFormView with error message:" + e, Alert.AlertType.ERROR);
        }
    }
*/
    @Override
    public void onDataChanged() {
        updateTableView();
    }

    private void initEditButtons() {
        tableColumnEdit.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        tableColumnEdit.setCellFactory(param -> new TableCell<Seller, Seller>() {
            private final Button button = new Button("edit");

            @Override
            protected void updateItem(Seller seller, boolean empty) {
                super.updateItem(seller, empty);
                if (seller == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(button);
                button.setOnAction( event -> System.out.println("test"));
                       /* event -> createDialogFormView(
                                service,seller,"/gui/SellerFormView.fxml", Utils.currentStage(event)));*/
            }
        });
    }

    private void initRemoveButtons() {
        tableColumnRemove.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        tableColumnRemove.setCellFactory(param -> new TableCell<Seller, Seller>() {
            private final Button button = new Button("remove");
            @Override
            protected void updateItem(Seller seller, boolean empty) {
                super.updateItem(seller, empty);
                if (seller == null) {
                    setGraphic(null);
                    return;
                }
                setGraphic(button);
                button.setOnAction(event -> removeEntity(seller));
            }
        });
    }
    private void removeEntity(Seller seller){
        Optional<ButtonType> resultAlert = Alerts.showConfirmation("Confirm deletion", "Are you sure you want to delete this seller? ");
        if(resultAlert.get() == ButtonType.OK){
            if(service==null){
                throw new IllegalStateException("Service variable is null when accessed");
            }
            try {
                service.delete(seller);
                updateTableView();
            } catch (DbException e) {
                Alerts.showAlert("Error removing object", null,e.getMessage(), Alert.AlertType.ERROR);
            }
        }
    }

}
