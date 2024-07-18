package org.example.petproject.controllers.laboratory.tasksForLaboratoryControllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.example.petproject.controllers.BaseController;

import java.lang.reflect.InvocationTargetException;
import java.net.URL;
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
    @FXML
    TextField textFieldForLanguage;
    @FXML
    TextField textFieldForAuthor;
    @FXML
    TextField textFieldForYear;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        setupLanguageColumn(languageColumn, "language");
        setupLanguageColumn(authorColumn, "author");
        setupLanguageColumn(yearColumn, "year");

        table.setEditable(true);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_ALL_COLUMNS);
        table.getItems().add(new LanguageInfo("C", "Денис Ритчи", "1972"));
        table.getItems().add(new LanguageInfo("C++", "Бьерн Страуструп", "1983"));
        table.getItems().add(new LanguageInfo("Python", "Гвидо ван Россум", "1991"));
        table.getItems().add(new LanguageInfo("Java", "Джеймс Гослинг", "1995"));
        table.getItems().add(new LanguageInfo("JavaScript", "Брендон Айк", "1995"));
        table.getItems().add(new LanguageInfo("C#", "Андрес Хейлсберг", "2001"));
        table.getItems().add(new LanguageInfo("Scala", "Мартин Одерски", "2003"));
    }

    @FXML
    protected void onAddButtonClick() {
        table.getItems().add(new LanguageInfo(textFieldForLanguage.getText(), textFieldForAuthor.getText(), textFieldForYear.getText()));
    }

    private void setupLanguageColumn(TableColumn<LanguageInfo, String> column, String name) {
        column.setCellValueFactory(new PropertyValueFactory<>(name));
        column.setCellFactory(TextFieldTableCell.forTableColumn());
        column.setOnEditCommit(event -> {
            LanguageInfo languageInfo = event.getRowValue();
            try {
                languageInfo
                        .getClass()
                        .getMethod("set" + name.substring(0, 1).toUpperCase() + name.substring(1), String.class)
                        .invoke(languageInfo, event.getNewValue());
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });
    }
}

