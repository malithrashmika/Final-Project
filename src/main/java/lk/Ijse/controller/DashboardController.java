package lk.Ijse.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

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
    private Label lblID;

    @FXML
    private Label lblname;

    @FXML
    private Label lblprice;

    @FXML
    private Label lblqtyOnHand;

    @FXML
    private Label lblqtyonHnad;

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtqty;

    private Stage stage;
    private Scene scene;

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {

    }

    @FXML
    void btnBookOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane=FXMLLoader.load(getClass().getResource("/lk/Ijse/Bookings.fxml"));
        root.getChildren().clear();
        root.getChildren().add(anchorPane);
    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) throws IOException {
        Button btn = (Button) event.getSource();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/customer.fxml"));
        Parent customerRoot = loader.load();

        // Get the root pane of the current scene
        Pane rootPane = (Pane) btn.getScene().getRoot();

        // Add the content loaded from customer.fxml to the root pane
        rootPane.getChildren().add(customerRoot);

        // Optionally, you can adjust the size of the window to fit the new content

    }




    @FXML
    void btnHomeOnAction(ActionEvent event) {

    }

    @FXML
    void btnIngredientOnAction(ActionEvent event) {

    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) {

    }

    @FXML
    void btnMenuOnAction(ActionEvent event) {

    }

    @FXML
    void btnNewCustomerOnAction(ActionEvent event) {

    }

    @FXML
    void btnOrderDetailsOnAction(ActionEvent event) {

    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {

    }

    @FXML
    void btnRideOnAction(ActionEvent event) {

    }

    @FXML
    void btnStaffOnAction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("employee.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void btnSupplierOnAction(ActionEvent event) throws IOException {
        Button btn = (Button) event.getSource();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/supplier.fxml"));
        Parent customerRoot = loader.load();

        // Get the root pane of the current scene
        Pane rootPane = (Pane) btn.getScene().getRoot();

        // Add the content loaded from customer.fxml to the root pane
        rootPane.getChildren().add(customerRoot);

        // Optionally, you can adjust the size of the window to fit the new content
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.sizeToScene();
    }

    @FXML
    void btnUserOnAction(ActionEvent event) {

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
