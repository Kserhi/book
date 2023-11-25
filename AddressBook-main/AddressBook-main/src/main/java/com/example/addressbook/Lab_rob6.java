package com.example.addressbook;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

import java.io.IOException;

public class Lab_rob6 {

    @FXML
    private ComboBox comboBox;
    @FXML
    private Label lblAnwerCombo;

    @FXML
    private ChoiceBox choiceB;

    @FXML
    private Label lblAnwerChoice;

    @FXML
    private Button btnAnwerChoice;
    private Stage dialogStage;
    @FXML
    private Label idTrueAnswer;

    @FXML
    private CheckBox btnPohod;

    @FXML
    private CheckBox btnSklad;

    @FXML
    private CheckBox btnDryz;

    @FXML
    private CheckBox btnHnysh;

    @FXML
    private Button btnAnswer;

    private ToggleGroup radiotoggleGroup;

    @FXML
    private RadioButton radioLay;
    @FXML
    private RadioButton radioCode;
    @FXML
    private RadioButton radioHier;
    @FXML
    private RadioButton radioProp;
    @FXML
    private Label lblRadio;

    @FXML
    private Button nextLab;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }


    public void initialize() {
        idTrueAnswer.setText("");
        lblAnwerChoice.setText("");

        choiceB.getItems().addAll("Правильно", "Неправильно");

        lblAnwerCombo.setText("");
        comboBox.getItems().addAll("BorderPane", "AncorePane", "VBox", "HBox");

        lblRadio.setText("");
        radiotoggleGroup = new ToggleGroup();
        this.radioProp.setToggleGroup(radiotoggleGroup);
        this.radioLay.setToggleGroup(radiotoggleGroup);
        this.radioHier.setToggleGroup(radiotoggleGroup);
        this.radioCode.setToggleGroup(radiotoggleGroup);


    }

    @FXML
    public void nextLab() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Lab7.fxml"));
            Parent root = loader.load();
            Lab7 lab7 = loader.getController();

            Stage otherDialogStage = new Stage();
            otherDialogStage.setTitle("Практична робота №7");
            otherDialogStage.setMinHeight(480);
            otherDialogStage.setMinWidth(855);
            otherDialogStage.setMaxHeight(480);
            otherDialogStage.setMaxWidth(855);
            Scene scene = new Scene(root);
            otherDialogStage.setScene(scene);
            otherDialogStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void RadioAnswer(ActionEvent event) {
        if (this.radiotoggleGroup.getSelectedToggle().equals(this.radioCode))
            lblRadio.setText("Відповідь: Code");
        if (this.radiotoggleGroup.getSelectedToggle().equals(this.radioHier))
            lblRadio.setText("Відповідь: Hierarchy");
        if (this.radiotoggleGroup.getSelectedToggle().equals(this.radioLay))
            lblRadio.setText("Відповідь: Layout");
        if (this.radiotoggleGroup.getSelectedToggle().equals(this.radioProp))
            lblRadio.setText("Відповідь: Properties");

    }

    @FXML
    public void comboBoxPressed(ActionEvent event) {
        lblAnwerCombo.setText("Відповідь: " + comboBox.getValue().toString());
    }

    @FXML
    public void checkBoxAnswer(ActionEvent action) {
        String answer = "Ваша відповідь:";
        if (btnPohod.isSelected() & btnHnysh.isSelected() & btnDryz.isSelected() & !btnSklad.isSelected()) {
            answer += "\nПравильна";
        } else {
            answer += "\nНеправильна";
        }


        this.idTrueAnswer.setText(answer);
    }

    @FXML
    public void choiceBoxAnswer(ActionEvent event) {
        if (choiceB.getValue().toString().equals("Правильно")) {
            lblAnwerChoice.setText("Відповідь: " + "неправильна");

        } else {
            lblAnwerChoice.setText("Відповідь: " + "правильна");
        }

    }

}
