package controllers;


import javafx.scene.control.TextField;

public class Contrains {
    public static void setTextFieldToDouble(TextField txtField){
        txtField.textProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!= null && !newValue.matches("\\d*([\\,]\\d*)?")){
                txtField.setText(oldValue);
            }
        });
    }
    public static void setTextFieldToAMaxLength(TextField txtField, int max){
        txtField.textProperty().addListener((obs,oldValue,newValue)->{
            if(newValue!= null && newValue.length() > max){
                txtField.setText(oldValue);
            }
        });
    }
}
