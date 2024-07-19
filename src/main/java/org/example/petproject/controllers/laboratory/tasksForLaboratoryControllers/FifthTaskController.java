package org.example.petproject.controllers.laboratory.tasksForLaboratoryControllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.example.petproject.controllers.BaseController;
import org.example.petproject.core.json.ParserJson;
import org.example.petproject.core.json.RowsForTableJson;

import java.lang.reflect.InvocationTargetException;
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

        ArrayList<ArrayList<String>> rowsForTable = ParserJson.parseJson(
                "src/main/resources/org/example/petproject/JSONs/RowsOfTable.json",
                RowsForTableJson.class
        ).rows();
        rowsForTable.forEach(row -> table.getItems().add(new LanguageInfo(row.getFirst(), row.get(1), row.get(2))));
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

