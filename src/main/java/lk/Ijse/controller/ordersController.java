package lk.Ijse.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ordersController {

    @FXML
    private JFXButton btnAddToCart;

    @FXML
    private JFXComboBox<?> cmbCusID;

    @FXML
    private JFXComboBox<?> cmbEmpID;

    @FXML
    private JFXComboBox<?> cmbItemCode;

    @FXML
    private JFXComboBox<?> cmbstatus;

    @FXML
    private TableColumn<?, ?> colAction;

    @FXML
    private TableColumn<?, ?> colEmpID;

    @FXML
    private TableColumn<?, ?> colTotal;

    @FXML
    private TableColumn<?, ?> colitemID;

    @FXML
    private TableColumn<?, ?> colorderdes;

    @FXML
    private TableColumn<?, ?> colqty;

    @FXML
    private TableColumn<?, ?> colstatus;

    @FXML
    private TableColumn<?, ?> colunitPrice;

    @FXML
    private Label lblID;

    @FXML
    private Label lblTime;

    @FXML
    private Label lbldate;

    @FXML
    private Label lblname;

    @FXML
    private Label lblnetTotal;

    @FXML
    private Label lblprice;

    @FXML
    private Label lblqtyonHnad;

    @FXML
    private TableView<?> tblOrder;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtqty;


    @FXML
    private AnchorPane root;

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {

    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml"));
        Stage stage = (Stage) root.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Dashboard Form");
        stage.centerOnScreen();
    }

    @FXML
    void btnNewCustomerOnAction(ActionEvent event) {

    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {

    }

    @FXML
    void cmbCusOnAction(ActionEvent event) {

    }

    @FXML
    void cmbEmpOnAction(ActionEvent event) {

    }

    @FXML
    void cmbitemOnAction(ActionEvent event) {

    }

    @FXML
    void cmbstatusOnAction(ActionEvent event) {

    }

}
