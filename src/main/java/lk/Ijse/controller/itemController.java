package lk.Ijse.controller;

import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.Ijse.model.Item;
import lk.Ijse.repository.CustomerRepo;
import lk.Ijse.repository.ItemRepo;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class itemController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private JFXComboBox<?> cmbtype;

    @FXML
    private TableColumn<?, ?> colAction;

    @FXML
    private TableColumn<?, ?> colCode;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colQtyOnHand;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private TableColumn<?, ?> coltype;

    @FXML
    private ImageView item;

    @FXML
    private TableView<?> tblItem;

    @FXML
    private TextField txtcode;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtQtyOnHand;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtprice;

    @FXML
    private AnchorPane root;

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/Dashboard.fxml"));
        Stage stage = (Stage) root.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Dashboard Form");
        stage.centerOnScreen();
    }


    @FXML
    void btnSaveOnAction(ActionEvent event) {
        String code = txtcode.getText();
        String description = txtname.getText();
        String type= String.valueOf(cmbtype.getValue());
        double price = Double.parseDouble(txtprice.getText());
        int qtyOnHand = Integer.parseInt(txtQtyOnHand.getText());

        Item item = new Item(code, description, type, price, qtyOnHand);

        try {
            boolean isSaved = ItemRepo.save(item);
            if(isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "Item saved!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String code = txtcode.getText();
        String description = txtname.getText();
        String type= String.valueOf(cmbtype.getValue());
        double price = Double.parseDouble(txtprice.getText());
        int qtyOnHand = Integer.parseInt(txtQtyOnHand.getText());

        Item item = new Item(code, description,type, price, qtyOnHand);

        try {
            boolean isUpdated = ItemRepo.update(item);
            if(isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION, "item updated!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtId.getText();

        try {
            boolean isDeleted = CustomerRepo.delete(id);
            if(isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION, "customer deleted!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void cmbItemOnAction(ActionEvent event) {
        String id = (String) cmbtype.getValue();
        try {
           Item item1 =ItemRepo.searchById(id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        txtcode.setText("");
        txtname.setText("");
        txtprice.setText("");
        txtQtyOnHand.setText("");
    }
}


