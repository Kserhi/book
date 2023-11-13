package com.example.addressbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class HelloController {
    @FXML
    private Label label;

    public HelloController() {
    }


    @FXML
    private Button btnAdd;

    @FXML
    void showDialog(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("second.fxml"));
        try {
            Stage stage = new Stage();
            Scene scene = new Scene(fxmlLoader.load(), 500, 150);
            stage.setScene(scene);

            stage.setTitle("Редагування");
            stage.setMinHeight(150);
            stage.setMinWidth(500);
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(btnAdd.getScene().getWindow());
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    @FXML
//    void new_Alert(ActionEvent event) {
//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.setTitle("Видалення");
//        alert.setHeaderText("Results");
//        alert.setContentText("Ви успішно видалили запис!");
//        alert.showAndWait();
//    }

        @FXML
    void new_Alert(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Видалення");
        alert.setHeaderText("Results:");
        alert.setContentText("Видалення може призвести до зміни порядку осіб у  Адресній книзі! ");
        alert.showAndWait();
    }
//    @FXML
//    void information_Alert(ActionEvent event) {
//
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle("Видалення");
//        alert.setContentText("Ви впевненні, що хочете видалити запис? ");
//
//        Optional<ButtonType> result = alert.showAndWait();
//
//        if (result.isPresent() && result.get() == ButtonType.OK) {
//            this.label.setText("Запис видалено!");
//        } else {
//            this.label.setText("Відмінено або немає вибору!");
//        }
//
//
//
//    }
}