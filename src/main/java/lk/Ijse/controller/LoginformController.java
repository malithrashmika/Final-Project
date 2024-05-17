package lk.Ijse.controller;


import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.Ijse.db.DbConnection;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginformController {
    @FXML
    private JFXButton Loginbtn;
    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUserId;


    @FXML
    void btnLoginOnAction(ActionEvent event) throws SQLException {
        String userId = txtUserId.getText();
        String pw = txtPassword.getText();


        try {
            checkCredential(userId, pw);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }

    private void checkCredential(String userId, String pw) throws SQLException, IOException {
        String sql = "SELECT user_id, password FROM users WHERE user_id = ?";

        Connection connection = DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setObject(1, userId);

        ResultSet resultSet = pstm.executeQuery();
        if(resultSet.next()) {
            String dbPw = resultSet.getString("password");

            if(pw.equals(dbPw)) {
                navigateToTheDashboard();
            } else {
                new Alert(Alert.AlertType.ERROR, "sorry! password is incorrect!").show();
            }

        } else {
            new Alert(Alert.AlertType.INFORMATION, "sorry! user id can't be find!").show();
        }
    }

    private void navigateToTheDashboard() throws IOException {
        AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/view/Dashboard.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Home.fxml"));

        Scene scene = new Scene(rootNode);
        Stage stage= (Stage) this.root.getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Dashboard Form");
/*        try {
            // Load the Customer.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Home.fxml"));
            Parent rootNode = loader.load();

            // Assuming 'root' refers to the root AnchorPane in your current scene
            // Clear the children of the root AnchorPane
            root.getChildren().clear();

            // Add the loaded rootNode as a child to the root AnchorPane
            root.getChildren().add(rootNode);

            // Ensure that the loaded content fits and appears in the correct location
            AnchorPane.setTopAnchor(rootNode, 0.0);
            AnchorPane.setRightAnchor(rootNode, 0.0);
            AnchorPane.setBottomAnchor(rootNode, 0.0);
            AnchorPane.setLeftAnchor(rootNode, 0.0);

            // Optionally, you can adjust the size of the window to fit the new content
            Stage stage = (Stage) root.getScene().getWindow();
            stage.sizeToScene();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the IOException appropriately
        }*/
    }


    @FXML
    void linkRegistrationOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/Register.fxml"));

        Scene scene = new Scene(rootNode);
        Stage stage = new Stage();
        stage.setScene(scene);

        stage.setTitle("Registration Form");

        stage.show();
    }
    @FXML
    void pwOnAction(ActionEvent event) {
        Loginbtn.fire();
    }

}
