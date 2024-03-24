package com.report.reportcustomer;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class PopupController {
    @FXML
    private TextField textField;

    public String getText() {
        return textField.getText();
    }
}
