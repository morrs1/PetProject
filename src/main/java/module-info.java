module org.example.petproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.petproject to javafx.fxml;
    exports org.example.petproject;
}