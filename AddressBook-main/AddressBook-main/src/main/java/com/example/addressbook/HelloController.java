package com.example.addressbook;

import com.example.addressbook.book.CollectionAddressBook;
import com.example.addressbook.person.Person;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class HelloController {
    private CollectionAddressBook addressBookImpl = new CollectionAddressBook();

    @FXML
    private TableColumn<Person, String> columnPIP;
    @FXML
    private TableColumn<Person, String> columnPhone;
    @FXML
    private TableView<Person> tableAddressBook;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnEdit;

    @FXML
    private Label labelCount;

    @FXML
    public void  initialize() {
        columnPIP.setCellValueFactory(new PropertyValueFactory<Person, String>("name"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));
        addressBookImpl.getPersonList().addListener(new ListChangeListener<Person>() {
            @Override
            public void onChanged(Change<? extends Person> c) {
                updateCountLabel();
            }
        });

        addressBookImpl.fillTestData();

        tableAddressBook.setItems(addressBookImpl.getPersonList());

    }

    private void updateCountLabel(){
        labelCount.setText("Кількість записів: " + addressBookImpl.getPersonList().size());
    }



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



}