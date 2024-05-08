package lk.Ijse.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class PlaceOrderController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private JFXComboBox<?> ItemID;

    @FXML
    private AnchorPane Node;

    @FXML
    private JFXButton btnAddToCart;

    @FXML
    private Label lblID;

    @FXML
    private Label lblname;

    @FXML
    private Label lblprice;

    @FXML
    private Label lblprice1;

    @FXML
    private JFXComboBox<?> orderstatus;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private TextField txtqty;

    @FXML
    private JFXComboBox<?> waiterID;

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {

    }

    @FXML
    void btnNewCustomerOnAction(ActionEvent event) {

    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {

    }

}
