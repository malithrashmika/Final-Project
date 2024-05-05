package lk.Ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class employeeController {

    @FXML
    private JFXComboBox<?> cmbempRole;

    @FXML
    private TableColumn<?, ?> colempId;

    @FXML
    private TableColumn<?, ?> colempName;

    @FXML
    private TableColumn<?, ?> colempRole;

    @FXML
    private TableColumn<?, ?> colempTel;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<?> tblemployee;

    @FXML
    private JFXTextField txtTel;

    @FXML
    private JFXTextField txtempID;

    @FXML
    private JFXTextField txtname;

    @FXML
    private TextField txtsearchId;

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
    void txtSearchOnAction(ActionEvent event) {

    }

}
