package lk.Ijse.controller;

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
import javafx.scene.layout.AnchorPane;
import lk.Ijse.Util.Regex;
import lk.Ijse.Util.TextFieldRegex;
import lk.Ijse.model.Customer;
import lk.Ijse.model.Supplier;
import lk.Ijse.model.tm.SupplierTm;
import lk.Ijse.repository.CustomerRepo;
import lk.Ijse.repository.SupplierRepo;

import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class supplierController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        loadAllSupplier();
    }
    private void loadAllSupplier() {
        ObservableList<SupplierTm> obList = FXCollections.observableArrayList();

        try {
            List<Supplier> supplierList = SupplierRepo.getAll();
            for (Supplier supplier : supplierList) {
                SupplierTm tm = new SupplierTm(
                        supplier.getSupplierId(),
                        supplier.getSupplierName(),
                        supplier.getContactNumber(),
                        supplier.getContactEmail()
                );

                obList.add(tm);
            }

            tblSupplier.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colTel;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<SupplierTm> tblSupplier;

    @FXML
    private TextField txtID;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtSearchId;

    @FXML
    private TextField txtTel;

    @FXML
    private TextField txtemail;

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }
    private void clearFields() {
        txtID.setText("");
        txtName.setText("");
        txtTel.setText("");
        txtemail.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtID.getText();

        try {
            boolean isDeleted = SupplierRepo.delete(id);
            if(isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "Supplier deleted!").show();
                loadAllSupplier();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String id =txtID.getText();
        String name = txtName.getText();
        String tel = txtTel.getText();
        String email =txtemail.getText();

        Supplier supplier = new Supplier(id, name, tel, email);

        try {
            boolean isSaved = SupplierRepo.save(supplier);
            if (isValid()) {
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Supplier saved!").show();
                    clearFields();
                    loadAllSupplier();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id =txtID.getText();
        String name = txtName.getText();
        String tel = txtTel.getText();
        String email =txtemail.getText();

        Supplier supplier = new Supplier(id, name, tel, email);
        try {
            boolean isSaved = SupplierRepo.update(supplier);
            if (isValid()) {
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Supplier updated!").show();
                    clearFields();
                    loadAllSupplier();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void txtSearchOnAction(ActionEvent event) throws SQLException {
        String id = txtSearchId.getText();

        Supplier supplier = SupplierRepo.searchById(id);
        if (supplier != null) {
            txtID.setText(supplier.getSupplierId());
            txtName.setText(supplier.getSupplierName());
            txtTel.setText(supplier.getContactNumber());
            txtemail.setText(supplier.getContactEmail());
        } else {
            new Alert(Alert.AlertType.INFORMATION, "customer not found!").show();
        }
    }

    public boolean isValid(){
        if (!Regex.setTextColor(TextFieldRegex.ID,txtID)) return false;
        if (!Regex.setTextColor(TextFieldRegex.NAME,txtName)) return false;
        if (!Regex.setTextColor(TextFieldRegex.CONTACT,txtTel)) return false;
        if (!Regex.setTextColor(TextFieldRegex.EMAIL,txtemail)) return false;
        return true;
    }


    public void txtIDOnKeyRelease(javafx.scene.input.KeyEvent keyEvent) {
        Regex.setTextColor(TextFieldRegex.ID,txtID);

    }

    public void NameOnKeyRelease(javafx.scene.input.KeyEvent keyEvent) {
        Regex.setTextColor(TextFieldRegex.NAME,txtName);
    }

    public void contactOnKeyRelease(javafx.scene.input.KeyEvent keyEvent) {
        Regex.setTextColor(TextFieldRegex.CONTACT,txtTel);
    }

    public void EmailOnKeyRelease(javafx.scene.input.KeyEvent keyEvent) {
        Regex.setTextColor(TextFieldRegex.EMAIL,txtemail);
    }
}
