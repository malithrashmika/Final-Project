/*
package lk.Ijse.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.Ijse.model.Cart;
import lk.Ijse.model.Customer;
import lk.Ijse.model.Employee;
import lk.Ijse.model.Item;
import lk.Ijse.model.tm.CartTm;
import lk.Ijse.repository.CustomerRepo;
import lk.Ijse.repository.EmployeeRepo;
import lk.Ijse.repository.ItemRepo;
import lk.Ijse.repository.OrderRepo;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class PlaceOrderController implements Initializable {
    @FXML
    private JFXComboBox<String> ItemID;

    @FXML
    private AnchorPane Node;

    @FXML
    private JFXButton btnAddToCart;

    @FXML
    private Label lblID;

    @FXML
    private Label lblQtyOnHand;

    @FXML
    private Label lblname;

    @FXML
    private Label lblprice;

    @FXML
    private Label lblCustomerName;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private TextField txtqty;

    @FXML
    private JFXComboBox<String> waiterID;

    private ObservableList<CartTm> obList;
    private double netTotal;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getCurrentOrderId();
        getWaiterIds();
        getItemCodes();
    }

    private void getItemCodes() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<String> codeList = ItemRepo.getcode();
            obList.addAll(codeList);
            ItemID.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void getWaiterIds() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<String> idList = EmployeeRepo.getIds();
            obList.addAll(idList);
            waiterID.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void getCurrentOrderId() {
        try {
            String currentId = OrderRepo.getCurrentId();
            String nextOrderId = generateNextOrderId(currentId);
            lblID.setText(nextOrderId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String generateNextOrderId(String currentId) {
        if(currentId != null) {
            String[] split = currentId.split("O");
            int idNum = Integer.parseInt(split[1]);
            return "O" + ++idNum;
        }
        return "O1";
    }

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {
        String code = ItemID.getValue();
        String name = lblname.getText();
        int qty = Integer.parseInt(txtqty.getText());
        double unitPrice = Double.parseDouble(lblprice.getText());
        double total = qty * unitPrice;

        // Create a new JFXButton for removing the item
        JFXButton btnRemove = new JFXButton("remove");
        btnRemove.setCursor(Cursor.HAND);

        // Initialize obList if it's not already initialized
        if (obList == null) {
            obList = FXCollections.observableArrayList();
        }

        Cart cart = new Cart(code, name, total, qty, unitPrice, btnRemove);

        // Call setValues method in ordersController to add the item to the cart table
        ordersController controller = new ordersController();
        controller.setValues(cart);


        // Get the reference to the OrdersController and update its TableView
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("orders.fxml"));
            Parent root = loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Calculate net total and clear quantity field
//        calculateNetTotal();
    }


    @FXML
    void btnNewCustomerOnAction(ActionEvent event) {

    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {

    }
    @FXML
    void cmbEmployeeOnAction(ActionEvent event) {
        String id = waiterID.getId() ;
        try {
            Employee employee = EmployeeRepo.searchById(id);

            //lblCustomerName.setText(customer.getName());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void cmbItemOnAction(ActionEvent event) {
        String code = ItemID.getValue();

        try {
            Item item = ItemRepo.searchById(code);
            if(item != null) {
                lblname.setText(item.getDescription());
                lblprice.setText(String.valueOf(item.getPrice()));
                lblQtyOnHand.setText(String.valueOf(item.getQtyOnHand()));
            }

            txtqty.requestFocus();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void cmbTableOnAction(ActionEvent event) {

    }

    @FXML
    void txtCustomerOnAction(ActionEvent event) {
        String contact = txtContact.getText(); ;
        try {
            Customer customer = CustomerRepo.searchByContact(contact);

            lblCustomerName.setText(customer.getName());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
*/



/*package lk.Ijse.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.Ijse.model.Cart;
import lk.Ijse.model.Customer;
import lk.Ijse.model.Employee;
import lk.Ijse.model.Item;
import lk.Ijse.model.tm.CartTm;
import lk.Ijse.repository.CustomerRepo;
import lk.Ijse.repository.EmployeeRepo;
import lk.Ijse.repository.ItemRepo;
import lk.Ijse.repository.OrderRepo;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class PlaceOrderController implements Initializable {
    @FXML
    private JFXComboBox<String> ItemID;

    @FXML
    private AnchorPane Node;

    @FXML
    private JFXButton btnAddToCart;

    @FXML
    private Label lblID;

    @FXML
    private Label lblQtyOnHand;

    @FXML
    private Label lblname;

    @FXML
    private Label lblprice;

    @FXML
    private Label lblCustomerName;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private TextField txtqty;

    @FXML
    private JFXComboBox<String> waiterID;

    private ObservableList<CartTm> obList;
    private double netTotal;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getCurrentOrderId();
        getWaiterIds();
        getItemCodes();
    }

    private void getItemCodes() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<String> codeList = ItemRepo.getcode();
            obList.addAll(codeList);
            ItemID.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void getWaiterIds() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<String> idList = EmployeeRepo.getIds();
            obList.addAll(idList);
            waiterID.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void getCurrentOrderId() {
        try {
            String currentId = OrderRepo.getCurrentId();
            String nextOrderId = generateNextOrderId(currentId);
            lblID.setText(nextOrderId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String generateNextOrderId(String currentId) {
        if(currentId != null) {
            String[] split = currentId.split("O");
            int idNum = Integer.parseInt(split[1]);
            return "O" + ++idNum;
        }
        return "O1";
    }

    @FXML
    void btnAddToCartOnAction(ActionEvent event) {
        String code = ItemID.getValue();
        String name = lblname.getText();
        int qty = Integer.parseInt(txtqty.getText());
        double unitPrice = Double.parseDouble(lblprice.getText());
        double total = qty * unitPrice;

        // Create a new JFXButton for removing the item
        JFXButton btnRemove = new JFXButton("remove");
        btnRemove.setCursor(Cursor.HAND);

        // Initialize obList if it's not already initialized
        if (obList == null) {
            obList = FXCollections.observableArrayList();
        }

        Cart cart = new Cart(code, name, total, qty, unitPrice, btnRemove);

        // Add the item to the cart table
        obList.add(new CartTm(cart.getCode(), cart.getDescription(), cart.getUnitPrice(), cart.getQty(), cart.getTotal(), cart.getBtnRemove()));

        // Update the net total and clear quantity field
        calculateNetTotal();
        txtqty.clear();
    }

    private void calculateNetTotal() {
        netTotal = 0;
        for (CartTm item : obList) {
            netTotal += item.getTotal();
        }
        // Update UI with net total
        // lblNetTotal.setText(String.valueOf(netTotal));
    }

    @FXML
    void cmbEmployeeOnAction(ActionEvent event) {
        String id = waiterID.getValue();
        try {
            Employee employee = EmployeeRepo.searchById(id);
            //lblCustomerName.setText(customer.getName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void cmbItemOnAction(ActionEvent event) {
        String code = ItemID.getValue();
        try {
            Item item = ItemRepo.searchById(code);
            if(item != null) {
                lblname.setText(item.getDescription());
                lblprice.setText(String.valueOf(item.getPrice()));
                lblQtyOnHand.setText(String.valueOf(item.getQtyOnHand()));
            }
            txtqty.requestFocus();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void cmbTableOnAction(ActionEvent event) {
        // Handle table selection
    }

    @FXML
    void txtCustomerOnAction(ActionEvent event) {
        String contact = txtContact.getText();
        try {
            Customer customer = CustomerRepo.searchByContact(contact);
            lblCustomerName.setText(customer.getName());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}*/



//package lk.Ijse.controller;
//
//import com.jfoenix.controls.JFXButton;
//import com.jfoenix.controls.JFXComboBox;
//import com.jfoenix.controls.JFXTextField;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Cursor;
//import javafx.scene.Parent;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.AnchorPane;
//import lk.Ijse.model.Cart;
//import lk.Ijse.model.Customer;
//import lk.Ijse.model.Employee;
//import lk.Ijse.model.tm.CartTm;
//import lk.Ijse.repository.CustomerRepo;
//import lk.Ijse.repository.EmployeeRepo;
//import lk.Ijse.repository.ItemRepo;
//import lk.Ijse.repository.OrderRepo;
//
//import java.net.URL;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.ResourceBundle;
//
//public class PlaceOrderController implements Initializable {
//
//    @FXML
//    private JFXComboBox<String> ItemID;
//
//    @FXML
//    private AnchorPane Node;
//
//    @FXML
//    private JFXButton btnAddToCart;
//
//    @FXML
//    private Label lblID;
//
//    @FXML
//    private Label lblQtyOnHand;
//
//    @FXML
//    private Label lblname;
//
//    @FXML
//    private Label lblprice;
//
//    @FXML
//    private Label lblCustomerName;
//
//    @FXML
//    private JFXTextField txtContact;
//
//    @FXML
//    private TextField txtqty;
//
//    @FXML
//    private JFXComboBox<String> waiterID;
//
//    private ObservableList<CartTm> obList;
//    private double netTotal;
//
//    @Override
//    public void initialize(URL url, ResourceBundle resourceBundle) {
//        getCurrentOrderId();
//        getWaiterIds();
//        getItemCodes();
//    }
//
//    private void getItemCodes() {
//        ObservableList<String> obList = FXCollections.observableArrayList();
//        try {
//            List<String> codeList = ItemRepo.getcode();
//            obList.addAll(codeList);
//            ItemID.setItems(obList);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private void getWaiterIds() {
//        ObservableList<String> obList = FXCollections.observableArrayList();
//        try {
//            List<String> idList = EmployeeRepo.getIds();
//            obList.addAll(idList);
//            waiterID.setItems(obList);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private void getCurrentOrderId() {
//        try {
//            String currentId = OrderRepo.getCurrentId();
//            String nextOrderId = generateNextOrderId(currentId);
//            lblID.setText(nextOrderId);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private String generateNextOrderId(String currentId) {
//        if(currentId != null) {
//            String[] split = currentId.split("O");
//            int idNum = Integer.parseInt(split[1]);
//            return "O" + ++idNum;
//        }
//        return "O1";
//    }
//
//    @FXML
//    void btnAddToCartOnAction(ActionEvent event) {
//        String code = ItemID.getValue();
//        String name = lblname.getText();
//        int qty = Integer.parseInt(txtqty.getText());
//        double unitPrice = Double.parseDouble(lblprice.getText());
//        double total = qty * unitPrice;
//
//        // Create a new JFXButton for removing the item
//        JFXButton btnRemove = new JFXButton("remove");
//        btnRemove.setCursor(Cursor.HAND);
//
//        // Initialize obList if it's not already initialized
//        if (obList == null) {
//            obList = FXCollections.observableArrayList();
//        }
//
//        // Create a CartTm object and add it to the obList
//        CartTm cartTm = new CartTm(code, name, unitPrice, qty, total, btnRemove);
//        obList.add(cartTm);
//
//        // Calculate net total and clear quantity field
//        calculateNetTotal();
//    }
//
//    private void calculateNetTotal() {
//        netTotal = 0;
//        for (CartTm cartTm : obList) {
//            netTotal += cartTm.getTotal();
//        }
//        // Update UI with net total
//        // lblNetTotal.setText(String.valueOf(netTotal));
//    }
//
//    @FXML
//    void txtCustomerOnAction(ActionEvent event) throws SQLException {
//        String contact = txtContact.getText();
//        // Lookup customer by contact and update UI with customer name
//         Customer customer = CustomerRepo.searchByContact(contact);
//        // lblCustomerName.setText(customer.getName());
//    }
//
//    @FXML
//    void cmbEmployeeOnAction(ActionEvent event) throws SQLException {
//        String id = waiterID.getValue();
//        // Lookup employee by ID and update UI
//         Employee employee = EmployeeRepo.searchById(id);
//    }
//
//    @FXML
//    void cmbItemOnAction(ActionEvent event) {
//        String code = ItemID.getValue();
//        // Lookup item by code and update UI
//        // Item item = ItemRepo.searchById(code);
//        // lblname.setText(item.getDescription());
//        // lblprice.setText(String.valueOf(item.getPrice()));
//        // lblQtyOnHand.setText(String.valueOf(item.getQtyOnHand()));
//        // txtqty.requestFocus();
//    }
//
//    @FXML
//    void btnNewCustomerOnAction(ActionEvent event) {
//        // Handle new customer button action
//    }
//
//    @FXML
//    void btnPlaceOrderOnAction(ActionEvent event) {
//        // Handle place order button action
//    }
//    @FXML
//    void cmbTableOnAction(ActionEvent event) {
//        // Your event handling code here
//    }
//
//}
