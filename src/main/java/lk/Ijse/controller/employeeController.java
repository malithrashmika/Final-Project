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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.Ijse.Util.Regex;
import lk.Ijse.Util.TextFieldRegex;
import lk.Ijse.db.EmployeeRoles;
import lk.Ijse.model.Customer;
import lk.Ijse.model.Employee;
import lk.Ijse.model.tm.EmployeeTm;
import lk.Ijse.repository.CustomerRepo;
import lk.Ijse.repository.EmployeeRepo;

import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class employeeController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCellValueFactory();
        loadAllEmployees();
        ObservableList<EmployeeRoles> roles = FXCollections.observableArrayList(EmployeeRoles.values());
        cmbEmpRole.setItems(roles);
    }

    @FXML
        private ComboBox<EmployeeRoles> cmbEmpRole;

        @FXML
        private TableColumn<?, ?> colempId;

        @FXML
        private TableColumn<?, ?> colempName;
       @FXML
       private TableColumn<?, ?> colempTel;

        @FXML
        private TableColumn<?, ?> colempRole;
       @FXML
       private TableColumn<?, ?> colempSalary;

        @FXML
        private AnchorPane root;

        @FXML
        private TableView<EmployeeRepo> tblemployee;

        @FXML
        private TextField txtId;

        @FXML
        private TextField txtName;

        @FXML
        private TextField txtsearchId;

        @FXML
        private TextField txttel;
    @FXML
    private TextField txtSalary;


    ObservableList<EmployeeRepo> obList = FXCollections.observableArrayList();


    private void loadAllEmployees() {

        try {
            List<Employee> employeeList = EmployeeRepo.getAll();
            for (Employee employee : employeeList) {
                EmployeeTm emptm = new EmployeeTm(
                        employee.getId(),
                        employee.getName(),
                        employee.getTel(),
                        employee.getSalary(),
                        employee.getRole()
                );

                obList.add(emptm);
            }

            tblemployee.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void setCellValueFactory() {
        colempId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colempName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colempRole.setCellValueFactory(new PropertyValueFactory<>("Role"));
        colempTel.setCellValueFactory(new PropertyValueFactory<>("Tel"));
        colempSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
    }

    @FXML
    void EmpRoleOnAction(ActionEvent event) {
        EmployeeRoles selectedRole = cmbEmpRole.getValue();
        if (selectedRole != null) {

        }
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }
    private void clearFields() {
        txtId.setText("");
        txtName.setText("");
        txttel.setText("");
        txtSalary.setText("");
        cmbEmpRole.getItems().clear();
        txtsearchId.setText("");
    }

        @FXML
        void btnDeleteOnAction(ActionEvent event) {
            String id = txtId.getText();

            try {
                boolean isDeleted = EmployeeRepo.delete(id);
                if(isDeleted) {
                    new Alert(Alert.AlertType.CONFIRMATION, "employee deleted!").show();
                    clearFields();
                    loadAllEmployees();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }

        @FXML
        void btnSaveOnAction(ActionEvent event) {
            String id =txtId.getText();
            String name = txtName.getText();
            String tel = txttel.getText();
            String salary = txtSalary.getText();
            String Role =cmbEmpRole.getSelectionModel().getSelectedItem().toString();

            Employee employee = new Employee(id, name, tel,salary, Role);

            try {
                if (isValid()) {
                    boolean isSaved = EmployeeRepo.save(employee);
                    if (isValid()) {
                        if (isSaved) {
                            new Alert(Alert.AlertType.CONFIRMATION, "employee saved!").show();
                            clearFields();
                            obList.clear();
                            loadAllEmployees();
                        }
                    }
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        @FXML
        void btnUpdateOnAction(ActionEvent event) {
            String id = txtId.getText();
            String name = txtName.getText();
            String tel = txttel.getText();
            String salary = txtSalary.getText();
            String Role= cmbEmpRole.getSelectionModel().getSelectedItem().toString();

            Employee employee = new Employee(id, name, tel, salary, Role);

            try {
                boolean isUpdated = EmployeeRepo.update(employee);
                if (isValid()) {
                    if (isUpdated) {
                        new Alert(Alert.AlertType.CONFIRMATION, "employee updated!").show();
                        loadAllEmployees();
                    }
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            }
        }

        @FXML
        void txtSearchOnAction(ActionEvent event) throws SQLException {
            String id = txtsearchId.getText();

            Employee employee = EmployeeRepo.searchById(id);
            if (employee != null) {
                txtId.setText(employee.getId());
                txtName.setText(employee.getName());
                txttel.setText(employee.getTel());
                txtSalary.setText(employee.getSalary());
                cmbEmpRole.getItems().add(EmployeeRoles.valueOf(employee.getRole()));
            } else {
                new Alert(Alert.AlertType.INFORMATION, "customer not found!").show();
            }
        }
    public boolean isValid(){
        if (!Regex.setTextColor(TextFieldRegex.ID,txtId)) return false;
        if (!Regex.setTextColor(TextFieldRegex.NAME,txtName)) return false;
        if (!Regex.setTextColor(TextFieldRegex.CONTACT,txttel  )) return false;
        if (!Regex.setTextColor(TextFieldRegex.SALARY,txtSalary)) return false;
        return true;
    }
    public void txtSalaryOnKeyReleased(javafx.scene.input.KeyEvent keyEvent) {
        Regex.setTextColor(TextFieldRegex.PRICE,txtSalary);
    }

    public void txtEmployeeIDOnKeyReleased(javafx.scene.input.KeyEvent keyEvent) {
        Regex.setTextColor(TextFieldRegex.ID,txtId);
    }

    public void txtNameOnKeyReleased(javafx.scene.input.KeyEvent keyEvent) {
        Regex.setTextColor(TextFieldRegex.NAME,txtName);
    }

    public void txtContactOnKeyReleased(javafx.scene.input.KeyEvent keyEvent) {
        Regex.setTextColor(TextFieldRegex.CONTACT,txttel);
    }
}

