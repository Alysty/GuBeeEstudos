package controllers;

import entities.Department;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    //methods with direct attachment to the GUI
    @FXML
    public void buttonSaveAction(){
        System.out.println("Test action for button buttonSaveAction");
    }
    @FXML
    public void buttonCancelAction(){
        System.out.println("Test action for button buttonCancelAction");
    }

    //methods not attached to FXML directly

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
