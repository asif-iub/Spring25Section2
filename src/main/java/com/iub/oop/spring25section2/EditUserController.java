package com.iub.oop.spring25section2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class EditUserController
{
    @FXML
    public TextField usernameTF;
    @FXML
    private ComboBox< String > userTypeCB;
    @FXML
    private TextField passwordTF;

    public static boolean updateSuccess = false;
    private User user;

    @FXML
    public void initialize() {
        userTypeCB.getItems().addAll(
                "admin",
                "standard",
                "test"
        );
    }

    @FXML
    public void goBack(ActionEvent actionEvent) throws IOException {
        updateSuccess = false;
        SceneSwitcher.switchTo("userManagement.fxml", actionEvent);
    }

    @FXML
    public void logOut(ActionEvent actionEvent) throws IOException{
        SceneSwitcher.switchTo("login.fxml", actionEvent);
    }

    @FXML
    public void update(ActionEvent actionEvent) throws IOException {
        user.setUsername(usernameTF.getText());
        user.setPassword(passwordTF.getText());
        user.setUserType(userTypeCB.getValue());

        updateSuccess = true;
//        SceneSwitcher.switchTo("userManagement.fxml", actionEvent);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("userManagement.fxml"));
        Parent root = loader.load();

        UserManagementController controller = loader.getController();
        controller.setMessage("User updated successfully!");

        Stage stage = (Stage) usernameTF.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    public void setUser(User user) {
        this.user = user;

        usernameTF.setText(user.getUsername());
        passwordTF.setText(user.getPassword());
        userTypeCB.setValue(user.getUserType());
    }

    public User getUser() {
        return user;
    }
}