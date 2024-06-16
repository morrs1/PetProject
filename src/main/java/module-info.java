module org.example.petproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens org.example.petproject to javafx.fxml;
    exports org.example.petproject;
    exports org.example.petproject.controllers;
    opens org.example.petproject.controllers to javafx.fxml;
    exports org.example.petproject.core;
    opens org.example.petproject.core to javafx.fxml;
}