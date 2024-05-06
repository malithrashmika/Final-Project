package lk.Ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ingredientController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private ComboBox<?> cmbInCategory;

    @FXML
    private TableColumn<?, ?> cmbSupplier;

    @FXML
    private TableColumn<?, ?> colIName;

    @FXML
    private TableColumn<?, ?> colIUnitPrice;

    @FXML
    private TableColumn<?, ?> colIid;

    @FXML
    private TableColumn<?, ?> colIiqty;

    @FXML
    private TableColumn<?, ?> coliCategory;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<?> tblIngredients;

    @FXML
    private TextField txtInName;

    @FXML
    private TextField txtInQty_avalible;

    @FXML
    private TextField txtInUnitPrice;

    @FXML
    private TextField txtInid;

    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void cmbInCategoryOnAction(ActionEvent event) {

    }

    @FXML
    void cmbSupplierOnAction(ActionEvent event) {

    }

}
