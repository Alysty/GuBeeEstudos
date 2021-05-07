package controllers;


import javafx.scene.control.TextField;

public class Contrains {
    public static void setTextFieldMaxLength(TextField txt, int max) {
        txt.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null && newValue.length() > max) {
                txt.setText(oldValue);
            }
        });
    }
}
