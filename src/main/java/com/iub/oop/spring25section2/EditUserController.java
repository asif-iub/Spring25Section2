package com.iub.oop.spring25section2;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;

public class EditUserController
{
    @javafx.fxml.FXML
    public TextField usernameTF;
    @javafx.fxml.FXML
    private ComboBox< String > userTypeCB;
    @javafx.fxml.FXML
    private TextField passwordTF;

    public static boolean updateSuccess = false;

    @javafx.fxml.FXML
    public void initialize() {
        userTypeCB.getItems().addAll(
                "admin",
                "standard",
                "test"
        );

        User user = UserManagementController.userToEdit;
        usernameTF.setText(user.getUsername());
        passwordTF.setText(user.getPassword());
        userTypeCB.setValue(user.getUserType());
    }

    @javafx.fxml.FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        updateSuccess = false;
        SceneSwitcher.switchTo("userManagement.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void logOut(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.switchTo("login.fxml", actionEvent);
    }

    @javafx.fxml.FXML
    public void update(ActionEvent actionEvent) throws IOException {
        User user = UserManagementController.userToEdit;
        user.setUsername(usernameTF.getText());
        user.setPassword(passwordTF.getText());
        user.setUserType(userTypeCB.getValue());

        updateSuccess = true;
        SceneSwitcher.switchTo("userManagement.fxml", actionEvent);
    }
}