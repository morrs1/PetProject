module org.example.petproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires com.fasterxml.jackson.databind;


    opens org.example.petproject to javafx.fxml;
    exports org.example.petproject;
    exports org.example.petproject.core.json to com.fasterxml.jackson.databind;
    exports org.example.petproject.core.enums;
    exports org.example.petproject.controllers.menu;
    opens org.example.petproject.controllers.menu to javafx.fxml;
    exports org.example.petproject.controllers.laboratory;
    opens org.example.petproject.controllers.laboratory to javafx.fxml;
    exports org.example.petproject.controllers;
    opens org.example.petproject.controllers to javafx.fxml;
    exports org.example.petproject.controllers.laboratory.tasksForLaboratoryControllers to javafx.fxml;
    opens org.example.petproject.controllers.laboratory.tasksForLaboratoryControllers to javafx.fxml;
}