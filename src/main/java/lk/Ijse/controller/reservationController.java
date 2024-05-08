package lk.Ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class reservationController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private DatePicker DateOFR;

    @FXML
    private ComboBox<?> EndTime;

    @FXML
    private ComboBox<?> Starttime;

    @FXML
    private JFXComboBox<?> cmbCusID;

    @FXML
    private JFXComboBox<?> cmbEmpID;

    @FXML
    private JFXComboBox<?> cmbtablenumber;

    @FXML
    private TableColumn<?, ?> colDoR;

    @FXML
    private TableColumn<?, ?> colEmpID;

    @FXML
    private TableColumn<?, ?> colReservationtime;

    @FXML
    private TableColumn<?, ?> colReservationtime1;

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
    private AnchorPane root;

    @FXML
    private TableView<?> tblreservation;

    @FXML
    private JFXTextField txtReservationID;

    @FXML
    private JFXComboBox<?> txtSearchId;

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnMakeOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void cmbCusOnAction(ActionEvent event) {

    }

    @FXML
    void cmbEmpOnAction(ActionEvent event) {

    }

    @FXML
    void cmbEndTimeOnAction(ActionEvent event) {

    }

    @FXML
    void cmbsearchIDOnAction(ActionEvent event) {

    }

    @FXML
    void cmbstartTimeOnAction(ActionEvent event) {

    }

    @FXML
    void cmbtableNumOnAction(ActionEvent event) {

    }

    @FXML
    void datePickOnAction(ActionEvent event) {

    }

}
