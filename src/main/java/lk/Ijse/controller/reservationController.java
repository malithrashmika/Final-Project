package lk.Ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class reservationController {

    @FXML
    private DatePicker DateOFR;

    @FXML
    private JFXComboBox<?> cmbCusID;

    @FXML
    private JFXComboBox<?> cmbEmpID;

    @FXML
    private TableColumn<?, ?> colAction;

    @FXML
    private TableColumn<?, ?> colDoR;

    @FXML
    private TableColumn<?, ?> colEmpID;

    @FXML
    private TableColumn<?, ?> colReserveDate;

    @FXML
    private TableColumn<?, ?> colReserveID;

    @FXML
    private TableColumn<?, ?> colReserveTime;

    @FXML
    private TableColumn<?, ?> colTNId;

    @FXML
    private TableColumn<?, ?> colcusId;

    @FXML
    private Label lblRID;

    @FXML
    private Label lblRTime;

    @FXML
    private Label lblRdate1;

    @FXML
    private TableView<?> tblreservation;

    @FXML
    private TextField txtId;

    @FXML
    void btnBackOnAction(ActionEvent event) {

    }

    @FXML
    void btnMakeOnAction(ActionEvent event) {

    }

    @FXML
    void cmbCusOnAction(ActionEvent event) {

    }

    @FXML
    void cmbEmpOnAction(ActionEvent event) {

    }

    @FXML
    void datePickOnAction(ActionEvent event) {

    }

}
