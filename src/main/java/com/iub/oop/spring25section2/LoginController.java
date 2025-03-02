package com.iub.oop.spring25section2;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

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
    }

    @javafx.fxml.FXML
    public void login(ActionEvent actionEvent) {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        if (username.equals("asif") && password.equals("1234")) {
            errorLabel.setText("Log in successful");
        }
        else {
            errorLabel.setText("Incorrect username or password");
        }
    }
}