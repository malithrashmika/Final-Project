package lk.Ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.Ijse.Util.Regex;
import lk.Ijse.Util.TextFieldRegex;
import lk.Ijse.model.CustomerDTO;
import lk.Ijse.tm.CustomerTm;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class customerController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        loadAllCustomers();
    }

    private void loadAllCustomers() {
        ObservableList<CustomerTm> obList = FXCollections.observableArrayList();

        try {
            List<CustomerDTO> customerList = CustomerRepo.getAll();
            for (CustomerDTO customer : customerList) {
                CustomerTm tm = new CustomerTm(
                        customer.getId(),
                        customer.getName(),
                        customer.getTel(),
                        customer.getEmail()
                );

                obList.add(tm);
            }

            tblCustomer.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnUpdate;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colTel;

    @FXML
    private TableColumn<?, ?> colemail;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<CustomerTm> tblCustomer;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtTel;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtsearchId;

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("e_Tel"));
        colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }
    private void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txtTel.setText("");
        txtemail.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtId.getText();

        try {
            boolean isDeleted = CustomerRepo.delete(id);
            if(isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer deleted!").show();
                clearFields();
                loadAllCustomers();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id =txtId.getText();
        String name = txtName.getText();
        String tel = txtTel.getText();
        String email =txtemail.getText();

        CustomerDTO customer = new CustomerDTO(id, name, tel, email);

        try {
            boolean isSaved = CustomerRepo.save(customer);
            if (isValid()){
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer saved!").show();
                clearFields();
                loadAllCustomers();

            }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnUpdateOnaction(ActionEvent event) {
        String id = txtId.getText();
        String name = txtName.getText();
        String tel = txtTel.getText();
        String email =txtemail.getText();

        CustomerDTO customer = new CustomerDTO(id, name, tel,email);

        try {
            boolean isUpdated = CustomerRepo.update(customer);
            if (isValid()) {
                if (isUpdated) {
                    new Alert(Alert.AlertType.CONFIRMATION, "customer updated!").show();
                    loadAllCustomers();
                    clearFields();
                }
                new Alert(Alert.AlertType.ERROR, "Invalid Input").show();
            }

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
    @FXML
    void btnSearchOnAction(ActionEvent event) throws SQLException {
        String id = txtsearchId.getText();

        CustomerDTO customer = CustomerRepo.searchById(id);
        if (customer != null) {
            txtId.setText(customer.getId());
            txtName.setText(customer.getName());
            txtTel.setText(customer.getTel());
            txtemail.setText(customer.getEmail());
        } else {
            new Alert(Alert.AlertType.INFORMATION, "customer not found!").show();
        }
    }
    public boolean isValid(){
        if (!Regex.setTextColor(TextFieldRegex.ID,txtId)) return false;
        if (!Regex.setTextColor(TextFieldRegex.NAME,txtName)) return false;
        if (!Regex.setTextColor(TextFieldRegex.CONTACT,txtTel)) return false;
        if (!Regex.setTextColor(TextFieldRegex.EMAIL,txtemail)) return false;
        return true;
    }
    @FXML
    public void txtCustomerIDOnKeyReleased(KeyEvent keyEvent) {
        Regex.setTextColor(TextFieldRegex.ID,txtId);
    }

    @FXML
    void txtContactOnKeyReleased(KeyEvent event) {
        Regex.setTextColor(TextFieldRegex.CONTACT,txtTel);
    }

    @FXML
    void txtEmailOnKeyReleased(KeyEvent event) {
        Regex.setTextColor(TextFieldRegex.EMAIL,txtemail);
    }

    @FXML
    void txtNameOnKeyReleased(KeyEvent event) {
        Regex.setTextColor(TextFieldRegex.NAME,txtName);
    }
}
