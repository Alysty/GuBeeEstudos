package controllers;

import controllers.listener.DataChangeListener;
import entities.Department;
import entities.Seller;
import exceptions.DbException;
import exceptions.ValidationException;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;
import services.DepartmentServices;
import services.SellerServices;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class SellerFormViewController implements Initializable {
    // Declaration of attributes attached to FXML
    @FXML
    private TextField textFieldID;
    @FXML
    private TextField textFieldName;
    @FXML
    private TextField textFieldEmail;
    @FXML
    private DatePicker datePickerBirthDate;
    @FXML
    private TextField textFieldSalary;
    @FXML
    private ComboBox<Department> comboBoxDepartment;
    @FXML
    private Label labelErrorName;
    @FXML
    private Label labelErrorEmail;
    @FXML
    private Label labelErrorBirthDate;
    @FXML
    private Label labelErrorSalary;
    @FXML
    private Label labelErrorDepartment;
    @FXML
    private Button buttonSave;
    @FXML
    private Button buttonCancel;


    //Attributes not attached to FXML
    private Seller sellerEntity;
    private SellerServices sellerServices;
    private DepartmentServices departmentServices;
    private List<DataChangeListener> dataChangeListenerList= new ArrayList<>();

    //methods with direct attachment to the GUI
    @FXML
    public void buttonSaveAction(ActionEvent actionEvent){
        ValidationException validationException = new ValidationException("Validation error has occurred");
        try {
            if(textFieldName.getText() == null || textFieldName.getText().trim().equals("") ){
                validationException.addError("Name", "Name was not typed");
                throw validationException;
            }
            if(sellerServices == null){
                throw new IllegalStateException("sellerServices was null when accessed");
            }/*
            sellerServices.saveOrUpdate(
                    //Seller(Integer id, String name, String email, Date birthDate, Double baseSalary, Department department)
                    new Seller(
                            Utils.tryToParseIntElseNull(textFieldID.getText()),
                            textFieldName.getText(),
                            textFieldEmail.getText(),
                            datePickerBirthDate.getText(),
                            Utils.tryToParseDoubleElseNull(textFieldSalary.getText()),
                            comboBoxDepartment.get
                    )
            );*/
            notifyDataChangeListeners();
            Utils.currentStage(actionEvent).close();

        }catch(DbException e){
            Alerts.showAlert("Error saving object in the database", null, e.getMessage(), Alert.AlertType.ERROR);
        }catch(ValidationException e){
            if(validationException.getErrorsMap().containsKey("Name")) {
                labelErrorName.setText(validationException.getErrorsMap().get("Name"));
            }
        }catch(IllegalStateException e){
            Alerts.showAlert("Error accessing variable", null, e.getMessage(), Alert.AlertType.ERROR);
        }

    }

    
    @FXML
    public void buttonCancelAction(ActionEvent actionEvent){
        Utils.currentStage(actionEvent).close();
    }


    //methods not attached to FXML directly
    public void setServices(SellerServices sellerServices, DepartmentServices departmentServices){
        this.sellerServices = sellerServices;
        this.departmentServices = departmentServices;
    }
    public void setSellerEntity(Seller sellerEntity) {
        this.sellerEntity = sellerEntity;
    }
    public void updateFormData(){
        if(sellerEntity == null){
            throw new IllegalStateException("The sellerEntity variable was null when accessed");
        }
        if(sellerEntity.getId() == null){
            textFieldID.setText("");
        }else{
            textFieldID.setText(String.valueOf(sellerEntity.getId()));
        }
        textFieldName.setText(sellerEntity.getName());
        textFieldEmail.setText(sellerEntity.getEmail());
        textFieldSalary.setText(String.format("%.2f",sellerEntity.getBaseSalary()));
        if(sellerEntity.getBirthDate() != null) {
            datePickerBirthDate.setValue(LocalDate.ofInstant(sellerEntity.getBirthDate().toInstant(), ZoneId.systemDefault()));
        }
        if(sellerEntity.getDepartment() == null){
            comboBoxDepartment.getSelectionModel().selectFirst();
        }else{
            comboBoxDepartment.setValue(sellerEntity.getDepartment());
        }


    }
    public void subscribeToDataChangeListener(DataChangeListener dataChangeListener){
        dataChangeListenerList.add(dataChangeListener);
    }
    private void notifyDataChangeListeners() {
        for (DataChangeListener dataChangeListener: dataChangeListenerList) {
            dataChangeListener.onDataChanged();
        }
    }
    public void updateComboBox(){
        if (departmentServices == null){
            throw new IllegalStateException("The departmentServices variable was null when accessed");
        }
        comboBoxDepartment.setItems(FXCollections.observableArrayList(departmentServices.findAll()));
    }
    private void initializeComboBoxDepartment() {
        Callback<ListView<Department>, ListCell<Department>> factory = lv -> new ListCell<>() {
            @Override
            protected void updateItem(Department item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getName());
            }
        };
        comboBoxDepartment.setCellFactory(factory);
        comboBoxDepartment.setButtonCell(factory.call(null));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Contrains.setTextFieldMaxLength(textFieldName, 30);
        Contrains.setTextFieldMaxLength(textFieldEmail, 60);
        Contrains.setTextFieldDouble(textFieldSalary);
        Utils.formatDatePicker(datePickerBirthDate, "dd/MM/yyyy");
        initializeComboBoxDepartment();
    }
}
