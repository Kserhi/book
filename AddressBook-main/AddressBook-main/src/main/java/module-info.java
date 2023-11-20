module com.example.addressbook {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.addressbook to javafx.fxml;
    exports com.example.addressbook;
    exports com.example.addressbook.book;
    opens com.example.addressbook.book to javafx.fxml;
    exports com.example.addressbook.person;
    opens com.example.addressbook.person to javafx.fxml;
}