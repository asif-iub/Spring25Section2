package com.iub.oop.spring25section2;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController
{
    @javafx.fxml.FXML
    private PasswordField passwordTextField;
    @javafx.fxml.FXML
    private Label errorLabel;
    @javafx.fxml.FXML
    private TextField usernameTextField;

    @javafx.fxml.FXML
    public void initialize() {
        if (UserManagementController.userList.isEmpty())
            UserManagementController.userList.add(
                    new User("asif","1234", "admin")
            );
    }

    @javafx.fxml.FXML
    public void login(ActionEvent actionEvent) throws IOException {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        for (User u: UserManagementController.userList) {
            if (username.equals(u.getUsername())
                    && password.equals(u.getPassword())) {
                errorLabel.setText("Log in successful");
                // scene switching
                Parent root = FXMLLoader.load(
                        getClass().getResource("dashboard.fxml")
                );
                Scene scene = new Scene(root);
                Stage stage = (Stage) errorLabel.getScene().getWindow();
//            Stage stage = new Stage();
                stage.setScene(scene);
//            stage.show();
            } else {
                errorLabel.setText("Incorrect username or password");
            }
        }
    }
}