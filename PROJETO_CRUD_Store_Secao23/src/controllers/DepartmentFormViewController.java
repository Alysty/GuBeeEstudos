package controllers;

import Services.DepartmentServices;
import db.DbException;
import entities.Department;
import gui.util.Alerts;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DepartmentFormViewController implements Initializable {
    // Declaration of attributes attached to FXML
    @FXML
    private TextField textFieldID;
    @FXML
    private TextField textFieldName;
    @FXML
    private Label labelError;
    @FXML
    private Button buttonSave;
    @FXML
    private Button buttonCancel;
    //Attributes not attached to FXML
    private Department departmentEntity;
    private DepartmentServices departmentServices;
    //methods with direct attachment to the GUI
    @FXML
    public void buttonSaveAction(ActionEvent actionEvent){
        if(textFieldName.getText()==""){
            throw new IllegalStateException("textFieldName was not typed");
        }
        if(departmentServices == null){
            throw new IllegalStateException("departmentServices was null when accessed");
        }
        try {
            departmentServices.saveOrUpdate(
                    new Department(Utils.tryToParseIntElseNull(textFieldID.getText()), textFieldName.getText())
            );
            Utils.currentStage(actionEvent).close();
        }catch(DbException e){
            Alerts.showAlert("Error saving object in the database", null, e.getMessage(), Alert.AlertType.ERROR);
        }

    }
    @FXML
    public void buttonCancelAction(ActionEvent actionEvent){
        Utils.currentStage(actionEvent).close();
    }

    //methods not attached to FXML directly
    public void setDepartmentServices(DepartmentServices departmentServices){
        this.departmentServices = departmentServices;
    }
    public void setDepartmentEntity(Department departmentEntity) {
        this.departmentEntity = departmentEntity;
    }
    public void updateFormData(){
        if(departmentEntity == null){
            throw new IllegalStateException("The departmentEntity variable was null when accessed");
        }
        if(departmentEntity.getId() == null){
            textFieldID.setText("");
        }else{
            textFieldID.setText(String.valueOf(departmentEntity.getId()));
        }
        textFieldName.setText(departmentEntity.getName());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Contrains.setTextFieldMaxLength(textFieldName, 30);
    }
}
