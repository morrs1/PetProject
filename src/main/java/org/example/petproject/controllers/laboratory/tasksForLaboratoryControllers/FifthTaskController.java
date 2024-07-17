package org.example.petproject.controllers.laboratory.tasksForLaboratoryControllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.petproject.controllers.BaseController;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FifthTaskController extends BaseController implements Initializable {
    @FXML
    private TableView<LanguageInfo> table;

    @FXML
    private TableColumn<LanguageInfo, String> languageColumn;
    @FXML
    private TableColumn<LanguageInfo, String> authorColumn;
    @FXML
    private TableColumn<LanguageInfo, String> yearColumn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<LanguageInfo> list = FXCollections.observableList(new ArrayList<>());
        list.add(new LanguageInfo("C","Денис Ритчи", 1972));
        list.add(new LanguageInfo("C++", "Бьерн Страуструп", 1983));
        list.add(new LanguageInfo("Python", "Гвидо ван Россум", 1991));
        list.add(new LanguageInfo("Java", "Джеймс Гослинг", 1995));
        list.add(new LanguageInfo("JavaScript", "Брендон Айк", 1995));
        list.add(new LanguageInfo("C#", "Андрес Хейлсберг", 2001));
        list.add(new LanguageInfo("Scale", "Мартин Одерски", 2003));

        // Привязка данных к столбцам
        languageColumn.setCellValueFactory(new PropertyValueFactory<>("language"));
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));

        table.setItems(list);
    }
}

