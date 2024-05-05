package lk.Ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.Ijse.db.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class registerformController {

    @FXML
    private AnchorPane rootNode;

    @FXML
    private TextField txtPw;

    @FXML
    private TextField txtUserId;

    @FXML
    private TextField txtemail;
    @FXML
    private JFXButton registerbtn;


    @FXML
    void btnRegisterOnAction(ActionEvent event) {
        String userId = txtUserId.getText();
        String name = txtemail.getText();
        String password = txtPw.getText();

        try {
            boolean isSaved = saveUser(userId, name, password);
            if(isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION, "user saved!").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private boolean saveUser(String userId, String email, String password) throws SQLException {
        String sql = "INSERT INTO users VALUES(?, ?, ?)";

       /* DbConnection dbConnection = DbConnection.getInstance();
        Connection connection = dbConnection.getConnection();*/

        Connection connection = DbConnection.getInstance().getConnection();

        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, userId);
        pstm.setObject(2,email);
        pstm.setObject(3, password);

        return pstm.executeUpdate() > 0;
    }

    @FXML
    void pwOnAction(ActionEvent event) {
        registerbtn.fire();
    }

}
