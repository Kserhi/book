package com.example.addressbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Lab7 {
    private Stage newStage;
    @FXML
    private AnchorPane scenePane;
    @FXML
    private RadioMenuItem first;
    @FXML
    private TextField textField;
    @FXML
    private RadioMenuItem second;
    @FXML
    private ToggleGroup toggleContextText;
    @FXML
    public void toggleContextText(ActionEvent event) {
        if (toggleContextText.getSelectedToggle().equals(this.first))
            textField.setText("RandomText");
        else if (toggleContextText.getSelectedToggle().equals(this.second))
            textField.setText(null);
      
    }

    @FXML
   public void exitButton(ActionEvent event) {

        newStage = (Stage) scenePane.getScene().getWindow();
        System.out.println("Success");
        newStage.close();
    }
    @FXML
    void initialize() {
        // Ініціалізація ToggleGroup
        toggleContextText = new ToggleGroup();

        // Додаємо RadioMenuItem до ToggleGroup
        first.setToggleGroup(toggleContextText);
        second.setToggleGroup(toggleContextText);

    }

}
