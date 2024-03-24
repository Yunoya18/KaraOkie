package com.report.reportcustomer;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;

public class MainController {
    @FXML
    private Button pg1, pg2, pg3, pg4, pg5;

    @FXML
    private VBox p1, p2, p3, p4, p5;

    private boolean isTableViewAdded = false;
    private boolean isPage5ViewAdded = false;
    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<Object, Object> idColumn = new TableColumn<>();



    public void initialize() {
        addClickEventToColumnHeader(idColumn, "ID");
    }

    private void addClickEventToColumnHeader(TableColumn<?, ?> column, String columnHeader) {
        Label label = createColumnHeaderLabel(columnHeader);
        column.setGraphic(label);
        label.setOnMouseClicked(event -> {
            // Handle click event for the column header
            System.out.println("Clicked on column: " + columnHeader);

            showPopup();


        });
    }

    private Label createColumnHeaderLabel(String text) {
        Label label = new Label(text);
        label.setStyle("-fx-padding: 5px;");
        return label;
    }


    private void showPopup() {
        if (tableView.getScene() != null) {
            try {
                FXMLLoader loader = new FXMLLoader(PopupController.class.getResource("popup.fxml"));
                AnchorPane popupContent = loader.load();

                Stage stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initOwner(tableView.getScene().getWindow());

                PopupController controller = loader.getController();
                stage.setOnHidden(e -> {
//                    String text = controller.getText();
                    // Do something with the entered text, such as updating the TableView
//                    System.out.println("Entered text: " + text);
                });

                // Calculate the center position of the screen
                double centerX = Screen.getPrimary().getVisualBounds().getWidth() / 2;
                double centerY = Screen.getPrimary().getVisualBounds().getHeight() / 2;

                // Set the popup position relative to the screen's center
                stage.setScene(new Scene(popupContent));
                stage.setX(centerX - (popupContent.getPrefWidth() / 2));
                stage.setY(centerY - (popupContent.getPrefHeight() / 2));

                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // TableView is not yet part of a scene, handle this scenario accordingly
            System.err.println("TableView is not yet part of a scene. Popup initialization deferred.");
        }
    }



    @FXML
    private void handleButtonAction(ActionEvent event) {
        Button btn = (Button) event.getSource();
        String btnId = btn.getId();

        // Hide all panes
        p1.setVisible(false);
        p2.setVisible(false);
        p3.setVisible(false);
        p4.setVisible(false);
        p5.setVisible(false);

        // Show corresponding pane
        switch (btnId) {
            case "pg1":
                p1.setVisible(true);
                break;
            case "pg2":
                p2.setVisible(true);
                break;
            case "pg3":
                p3.setVisible(true);
                break;
            case "pg4":
                p4.setVisible(true);
                // If page 4 is clicked and TableView hasn't been added yet, show the TableView
                if (!isTableViewAdded) {
                    showTableData();
                    isTableViewAdded = true; // Set the flag to true indicating TableView has been added
                }
                break;
            case "pg5":
                p5.setVisible(true);
                if(!isPage5ViewAdded){
                    showPage5(); // Show page 5 content
                    isPage5ViewAdded = true;
                }
                break;
            default:
                break;
        }
    }

    private void showTableData() {
        try {
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("table_data.fxml"));
            Parent tableData = loader.load();
            p4.getChildren().add(tableData);
            tableView = (TableView<?>) tableData.lookup("#tableView");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showPage5() {
        try {
            FXMLLoader loader = new FXMLLoader(ReportDataController.class.getResource("report_data.fxml"));
            Parent page5 = loader.load();
            p5.getChildren().add(page5);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
