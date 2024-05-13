/*package lk.Ijse.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.Ijse.model.Cart;
import lk.Ijse.model.tm.CartTm;

import java.net.URL;
import java.util.ResourceBundle;

public class ordersController implements Initializable {
    @FXML
    private TableColumn<?, ?> colAction;

    @FXML
    private TableColumn<?, ?> colCartAction;

    @FXML
    private TableColumn<?, ?> colCartTotal;

    @FXML
    private TableColumn<?, ?> colCartitemID;

    @FXML
    private TableColumn<?, ?> colCartorderdes;

    @FXML
    private TableColumn<?, ?> colCartqty;

    @FXML
    private TableColumn<?, ?> colCartunitPrice;

    @FXML
    private TableColumn<?, ?> colEmpID;

    @FXML
    private TableColumn<?, ?> colOrderID;

    @FXML
    private TableColumn<?, ?> colReservationID;

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
    private AnchorPane root;

    @FXML
    private TableView<CartTm> tblCart;

    @FXML
    private TableView<?> tblOrder;
    private double netTotal;
    private Cart cart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCartCellValueFactory();
        setCellValueFactory();
        calculateNetTotal();
    }
    public void setOrder(Cart cart ) {
        this.cart = cart;
        // Update UI with order data
        tblCart.getItems().clear();
//        txtItemId.setText(order.getItemId());
//        txtQuantity.setText(String.valueOf(order.getQuantity()));
        // Update other UI components
    }
    private void calculateNetTotal() {
        netTotal = 0;
        for (int i = 0; i < tblCart.getItems().size(); i++) {
            netTotal += (double) colTotal.getCellData(i);
        }
       // lblNetTotal.setText(String.valueOf(netTotal));
    }

//    public void setValues(Cart cart) {
//        tblCart.getItems().add(cartTm);
//    }

//    private  void setCellValueFactory() {
//        colitemID.setCellValueFactory(new PropertyValueFactory<>("code"));
//        colorderdes.setCellValueFactory(new PropertyValueFactory<>("description"));
//        colunitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
//        colstatus.setCellValueFactory(new PropertyValueFactory<>("status"));
//        colEmpID.setCellValueFactory(new PropertyValueFactory<>("waiter"));
//        colqty.setCellValueFactory(new PropertyValueFactory<>("qty"));
//        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
//        colAction.setCellValueFactory(new PropertyValueFactory<>("btnRemove"));
//    }
    private  void setCartCellValueFactory() {
        colCartitemID.setCellValueFactory(new PropertyValueFactory<>("code"));
        colCartorderdes.setCellValueFactory(new PropertyValueFactory<>("description"));
        colCartunitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colCartqty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colCartTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colCartAction.setCellValueFactory(new PropertyValueFactory<>("btnRemove"));
    }
    public static void setValues(CartTm cartTm){
        cartTm.setCode(cartTm.getCode());
        cartTm.setDescription(cartTm.getDescription());
        cartTm.setUnitPrice(cartTm.getUnitPrice());
        cartTm.setQty(cartTm.getQty());
        cartTm.setTotal(cartTm.getTotal());
    }


}*/






package lk.Ijse.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.Ijse.model.Cart;
import lk.Ijse.model.tm.CartTm;

import java.net.URL;
import java.util.ResourceBundle;

public class ordersController implements Initializable {
    @FXML
    private TableColumn<?, ?> colAction;

    @FXML
    private TableColumn<?, ?> colCartAction;

    @FXML
    private TableColumn<?, ?> colCartTotal;

    @FXML
    private TableColumn<?, ?> colCartitemID;

    @FXML
    private TableColumn<?, ?> colCartorderdes;

    @FXML
    private TableColumn<?, ?> colCartqty;

    @FXML
    private TableColumn<?, ?> colCartunitPrice;

    @FXML
    private TableColumn<?, ?> colEmpID;

    @FXML
    private TableColumn<?, ?> colOrderID;

    @FXML
    private TableColumn<?, ?> colReservationID;

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
    private AnchorPane root;

    @FXML
    private TableView<CartTm> tblCart;

    @FXML
    private TableView<?> tblOrder;
    private double netTotal;
    private Cart cart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCartCellValueFactory();
        setCellValueFactory();
        calculateNetTotal();
    }

    public void setOrder(Cart cart) {
        this.cart = cart;
        // Update UI with order data
        tblCart.getItems().add(new CartTm(cart.getCode(), cart.getDescription(), cart.getUnitPrice(), cart.getQty(), cart.getTotal(), null));
        calculateNetTotal();
    }

    private void calculateNetTotal() {
        netTotal = 0;
        ObservableList<CartTm> items = tblCart.getItems();
        for (CartTm item : items) {
            netTotal += item.getTotal();
        }
        // lblNetTotal.setText(String.valueOf(netTotal));
    }

    private void setCellValueFactory() {
        // Add PropertyValueFactory for tblOrder columns
    }

    private void setCartCellValueFactory() {
        colCartitemID.setCellValueFactory(new PropertyValueFactory<>("code"));
        colCartorderdes.setCellValueFactory(new PropertyValueFactory<>("description"));
        colCartunitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colCartqty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colCartTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        colCartAction.setCellValueFactory(new PropertyValueFactory<>("btnRemove"));
    }
}

