package com.report.reportcustomer;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ReportDataController implements Initializable {


    @FXML
    private ChoiceBox<String> myChoiceBox;

    private String[] dropdown = {"Daily" , "Monthly" , "Yearly"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        myChoiceBox.getItems().addAll(dropdown);


        myChoiceBox.setValue("Daily");

    }
}
