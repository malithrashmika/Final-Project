/*package lk.Ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.Ijse.model.Customer;
import lk.Ijse.model.employee;
import lk.Ijse.repository.CustomerRepo;
import lk.Ijse.repository.EmployeeRepo;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class employeeController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

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

    private void setCellValueFactory() {
        colempId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colempName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colempTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        colempRole.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        txtempID.setText("");
        txtname.setText("");
        txtTel.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
       /* String id =txtempID.getText();
        String name = txtname.getText();
        String tel = txtTel.getText();
        String Role = String.valueOf(cmbempRole.getValue());

        employee employee = new employee(id, name, tel, Role);

        try {
            boolean isSaved = EmployeeRepo.save(employee);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
                clearFields();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/


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

public class employeeController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
        private ComboBox<?> cmbEmpRole;

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
        private TextField txtId;

        @FXML
        private TextField txtName;

        @FXML
        private TextField txtsearchId;

        @FXML
        private TextField txttel;

        @FXML
        void EmpRoleOnAction(ActionEvent event) {

        }

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

